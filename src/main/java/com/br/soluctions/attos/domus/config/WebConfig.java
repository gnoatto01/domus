package com.br.soluctions.attos.domus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Permite CORS para todas as rotas que começam com /api
                .allowedOrigins("http://localhost:3000") // Origem permitida
                .allowedMethods("*") // Métodos permitidos
                .allowedHeaders("Authorization", "Content-Type") // Cabeçalhos permitidos
                .allowCredentials(true);  // Permite o envio de cookies e cabeçalhos de autorização
    }
}
