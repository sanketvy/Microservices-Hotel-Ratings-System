package com.learning.user.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customSwaggerConfig(){
        return new OpenAPI().info(new Info().title("Learning User Service").description("User Service for microservices learning project"))
                .servers(Arrays.asList(new Server().url("http://localhost:8081").description("prod"), new Server().url("http://localhost:8080").description("dev")));
    }
}
