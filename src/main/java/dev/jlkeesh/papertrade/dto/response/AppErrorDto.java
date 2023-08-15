package dev.jlkeesh.papertrade.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class AppErrorDto {
    private String errorPath;
    private String errorMessage;
    private final Object errorBody;
    private final LocalDateTime timestamp = LocalDateTime.now();

    public AppErrorDto(Object errorBody) {
        this.errorBody = errorBody;
    }

    public AppErrorDto(String errorPath, Object errorBody) {
        this.errorPath = errorPath;
        this.errorBody = errorBody;
    }

    public AppErrorDto(String errorPath, String errorMessage, Object errorBody) {
        this(errorPath, errorBody);
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "AppErrorDto{" +
                "errorPath='" + errorPath + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", errorBody=" + errorBody +
                ", timestamp=" + timestamp +
                '}';
    }
}
