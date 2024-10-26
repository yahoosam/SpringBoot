package com.curiousbinary.springbootdemo.configuration;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Data
@Configuration
@Slf4j
@PropertySource(value = "file:${secrets.dbconfig}", factory = PropertySourceLoader.class)
public class DataSourceConfig {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${db.pgusername}")
    private String username;
    @Value("${db.pgpassword}")
    private String password;
    @Value("${spring.jpa.hibernate.default_schema}")
    private String schema;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Bean(name = "datasource")
    public DataSource dataSource() {
        log.info("url: {}, username: {}, schema: {}, driverClassName: {}", url, username, schema, driverClassName);

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setSchema(schema);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }
}
