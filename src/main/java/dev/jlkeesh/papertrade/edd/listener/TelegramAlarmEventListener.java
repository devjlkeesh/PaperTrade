package dev.jlkeesh.papertrade.edd.listener;

import dev.jlkeesh.papertrade.edd.events.TelegramAlarmEvent;
import dev.jlkeesh.papertrade.utils.TelegramUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

/**
 * @author : Elmurodov Javohir
 * @since : 05/06/23 / 15:45
 */


@Configuration
@ConditionalOnProperty(name = "telegram.alarmOnError")
@RequiredArgsConstructor
public class TelegramAlarmEventListener {

    private final TelegramUtil telegramUtil;

    @Async
    @EventListener(TelegramAlarmEvent.class)
    public void listen(TelegramAlarmEvent e) {
        telegramUtil.sendMessage(String.valueOf(e.message()));
    }

}
