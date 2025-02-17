package com.memory.refresh.memoryrefresh.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;

@Configuration
public class AppConfig {
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.driver-class-name}")
    private String dbdriver;

    @Value("${secrets.dbconfig}")
    private String dbConfigPath;

    private String dbUser;
    private String dbPassword;

    @Bean
    public DataSource getDataSource() throws IOException {
        loadDbCredentialsFromVault();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dbdriver);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    private void loadDbCredentialsFromVault() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File(dbConfigPath));

        JsonNode dbNode = jsonNode.get("db");
        dbUser = dbNode.get("pgusername").asText();
        dbPassword = dbNode.get("pgpassword").asText();
    }
}
