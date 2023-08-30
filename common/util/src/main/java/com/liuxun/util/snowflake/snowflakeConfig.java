package com.liuxun.util.snowflake;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.downgoon.snowflake.Snowflake;

/**
 * @author liuxun
 * @create 2023-07-21 20:53
 * @description
 */
@Configuration
public class snowflakeConfig {
    @Bean
    public Snowflake generateSnowflake(){
        return new Snowflake(1,1);
    }
}
