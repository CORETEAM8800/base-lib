package travel.letstrip.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import travel.letstrip.telegram.TelegramProperties;


@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(TelegramProperties.class)
@ConditionalOnProperty(prefix = "telegram.bot", name = "enabled", havingValue = "true")
public class TelegramAutoConfiguration {

    private final TelegramProperties properties;
    @Bean
    public TelegramClient telegramClient() {
        return new TelegramClient(properties);
    }

}
