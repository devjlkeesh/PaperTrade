package dev.jlkeesh.papertrade.configs;

import dev.jlkeesh.papertrade.edd.events.TelegramAlarmEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.Executor;


@Slf4j
@Configuration
@EnableAsync
@RequiredArgsConstructor
public class AsyncConfig implements org.springframework.scheduling.annotation.AsyncConfigurer {
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(20);
        taskExecutor.setKeepAliveSeconds(30);
        taskExecutor.setQueueCapacity(100);
        taskExecutor.setThreadNamePrefix("rams-");
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (e, method, params) -> {
            var out = new StringWriter();
            var printWriter = new PrintWriter(out);
            e.printStackTrace(printWriter);
            log.error("Error : On Method : {}, Input Parameters : {}, StackTrace : {}", method.getName(), params, out);
            eventPublisher.publishEvent(new TelegramAlarmEvent(out));
        };
    }

}
