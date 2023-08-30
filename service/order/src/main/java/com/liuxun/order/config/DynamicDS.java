package com.liuxun.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liuxun
 * @create 2023-07-23 20:47
 * @description
 */
@Component
@PropertySource(value = {"classpath:datasource.yml"},factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(value = "dynamic-ds")
@Data
public class DynamicDS {
    private List<DataSourceConfig> datasources;
    private DataSourceConfig rbda;
    private DataSourceConfig product;
//    @Component
    @Data
    public static class DataSourceConfig {
        private String url;
        private String username;
        private String password;
        private String driverClassName="com.mysql.jdbc.Driver";
    }
}
