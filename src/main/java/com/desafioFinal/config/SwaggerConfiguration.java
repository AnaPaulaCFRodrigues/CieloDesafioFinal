package com.desafioFinal.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Desafio Final",
                description = "API para CRUD Filas FIFO",
                version = "1.0.0"
        )
)

public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi controllers() {
        return GroupedOpenApi.builder()
                .group("Endpoints")
                .packagesToScan("com.desafioFinal.controller")
                .build();
    }

    @Bean
    public SwaggerUiConfigParameters swaggerUiConfigParameters() {
        return new SwaggerUiConfigParameters(new SwaggerUiConfigProperties());
    }

}

