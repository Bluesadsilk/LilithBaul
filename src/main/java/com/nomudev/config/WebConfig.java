package com.nomudev.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if (registry != null) { // Verificar que registry no sea nulo
            registry.addMapping("/**") // Permitir todas las rutas
                    .allowedOrigins("http://localhost:4321") // Cambia esto por el origen de tu aplicación
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS") // Métodos permitidos
                    .allowedHeaders("*") // Permitir todos los encabezados
                    .allowCredentials(true); // Permitir credenciales (opcional)
        }
    }
}
