package travel.letstrip.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

import jakarta.annotation.PostConstruct;

@Slf4j
@AutoConfiguration
public class LibConfig implements Ordered {

    @Value("${spring.application.name:Unknown Service}")
    private String applicationName;

    @Value("${server.port:8080}")
    private String serverPort;

    @PostConstruct
    public void init() {
        log.info("✅ Base-lib fully initialized");
        log.info("🏷️  Service: {}", applicationName);
        log.info("🔌 Port: {}", serverPort);
    }


    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}