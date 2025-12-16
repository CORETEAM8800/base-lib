package travel.letstrip.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class LibInitializer {
    
    private final String serviceName;

    public LibInitializer(String serviceName) {
        this.serviceName = serviceName;
        log.info("💡 LibInitializer created for: {}", serviceName);
    }
    
    public void printInfo() {
        log.info("📊 base-lib is active in: {}", serviceName);
    }
}