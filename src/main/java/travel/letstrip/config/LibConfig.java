package travel.letstrip.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

import jakarta.annotation.PostConstruct;

/**
 * Auto-configuration class for the base-lib module.
 *
 * <p>This configuration is automatically loaded by Spring Boot when the
 * library is present on the classpath.</p>
 *
 * <p>Responsibilities:</p>
 * <ul>
 *   <li>Logs basic application information on startup</li>
 *   <li>Ensures early initialization using {@link Ordered#HIGHEST_PRECEDENCE}</li>
 * </ul>
 *
 * <p>Logged information includes:</p>
 * <ul>
 *   <li>Application name ({@code spring.application.name})</li>
 *   <li>Server port ({@code server.port})</li>
 * </ul>
 *
 * <p>Default values are used if properties are not defined.</p>
 */
@Slf4j
@AutoConfiguration
public class LibConfig implements Ordered {

    /**
     * Spring application name.
     * Defaults to {@code "Unknown Service"} if not provided.
     */
    @Value("${spring.application.name:Unknown Service}")
    private String applicationName;

    /**
     * Server port on which the application is running.
     * Defaults to {@code 8080}.
     */
    @Value("${server.port:8080}")
    private String serverPort;

    /**
     * Called after dependency injection is complete.
     *
     * <p>Logs library initialization details.</p>
     */
    @PostConstruct
    public void init() {
        log.info("Base-lib fully initialized");
        log.info("Service: {}", applicationName);
        log.info("Port: {}", serverPort);
    }

    /**
     * Defines the loading order of this auto-configuration.
     *
     * @return highest precedence to ensure early initialization
     */
    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
