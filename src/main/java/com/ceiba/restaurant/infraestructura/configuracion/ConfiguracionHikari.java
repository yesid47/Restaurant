package com.ceiba.restaurant.infraestructura.configuracion;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
/*
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class ConfiguracionHikari extends HikariConfig {
    
    @Value("${spring.datasource.hikari.poolName}")
    private String poolName;

    @Bean
    public DataSource dataSource() {
        int poolSize = Runtime.getRuntime().availableProcessors() * 2 + 1;
        setMaximumPoolSize(poolSize);
        setPoolName(this.poolName);
        return new HikariDataSource(this);
    } 
}*/