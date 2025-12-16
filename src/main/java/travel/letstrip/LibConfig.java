package travel.letstrip;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Slf4j
@Configuration
@Order(1)
public  class LibConfig {



    @Bean

    public void init(){

        log.info("init LibConfig");
    }


}
