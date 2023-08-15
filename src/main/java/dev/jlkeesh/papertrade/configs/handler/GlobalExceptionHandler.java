package dev.jlkeesh.papertrade.configs.handler;

import dev.jlkeesh.papertrade.dto.response.AppErrorDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.edd.events.TelegramAlarmEvent;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.InternalServerErrorException;
import dev.jlkeesh.papertrade.exceptions.NotFoundException;
import dev.jlkeesh.papertrade.utils.BaseUtils;
import jakarta.persistence.PersistenceException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestControllerAdvice("uz.yt.ramsservice")
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final ApplicationEventPublisher eventPublisher;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Data<AppErrorDto>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        var errorPath = request.getRequestURI();
        var errorBody = new HashMap<String, List<String>>();
        for (var fieldError : e.getFieldErrors()) {
            var errorFieldName = fieldError.getField();
            var errorMessage = fieldError.getDefaultMessage();
            errorBody.compute(errorFieldName, (key, value) -> {
                var fieldErrorMessages = Objects.requireNonNullElse(value, new ArrayList<String>());
                fieldErrorMessages.add(errorMessage);
                return fieldErrorMessages;
            });
        }
        log.error("MethodArgumentNotValidException : {}", BaseUtils.getStackTrace(e));
        return new ResponseEntity<>(new Data<>(new AppErrorDto(errorPath, errorBody)), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Data<AppErrorDto>> handleNotFoundException(NotFoundException e, HttpServletRequest request) {
        var errorPath = request.getRequestURI();
        var errorBody = e.getMessage();
        var stackTrace = getStackTrace(e);
        log.error("ResourceNotFoundException : {}", stackTrace);
        eventPublisher.publishEvent(new TelegramAlarmEvent(stackTrace));
        return new ResponseEntity<>(new Data<>(new AppErrorDto(errorPath, errorBody)), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<Data<AppErrorDto>> handleInternalServerErrorException(InternalServerErrorException e, HttpServletRequest request) {
        var errorPath = request.getRequestURI();
        var errorBody = e.getMessage();
        var stackTrace = getStackTrace(e);
        log.error("InternalServerErrorException : {}", stackTrace);
        eventPublisher.publishEvent(new TelegramAlarmEvent(stackTrace));
        return new ResponseEntity<>(new Data<>(new AppErrorDto(errorPath, errorBody)), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Data<AppErrorDto>> handleBadRequestException(BadRequestException e, HttpServletRequest request) {
        var errorPath = request.getRequestURI();
        var errorBody = e.getMessage();
        log.error("BadRequestException : {}", getStackTrace(e));
        return new ResponseEntity<>(new Data<>(new AppErrorDto(errorPath, errorBody)), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(PersistenceException.class)
    public ResponseEntity<Data<AppErrorDto>> handlePersistenceException(PersistenceException e, HttpServletRequest request) {
        var errorPath = request.getRequestURI();
        var errorBody = ErrorCode.INTERNAL_SERVER_ERROR;
        var stackTrace = getStackTrace(e);
        log.error("PersistenceException : {}", stackTrace);
        eventPublisher.publishEvent(new TelegramAlarmEvent(stackTrace));
        return new ResponseEntity<>(new Data<>(new AppErrorDto(errorPath, errorBody)), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Data<AppErrorDto>> handleException(Exception e, HttpServletRequest request) {
        var errorPath = request.getRequestURI();
        var errorBody = e.getMessage();
        var stackTrace = getStackTrace(e);
        log.error("ResourceNotFoundException : {}", stackTrace);
        return new ResponseEntity<>(new Data<>(new AppErrorDto(errorPath, errorBody)), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @NotNull
    private String getStackTrace(Exception e) {
        return BaseUtils.getStackTrace(e);
    }

}
