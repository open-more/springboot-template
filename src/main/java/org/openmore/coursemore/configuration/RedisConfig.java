package org.openmore.coursemore.configuration;

import org.openmore.common.utils.RedisOps;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by michaeltang on 2018/3/29.
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedisOps redisOps(){
        return new RedisOps();
    }
}
