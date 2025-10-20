package com.FitnessSACSpring;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Inicializador de servlet para despliegue como WAR en contenedores externos (Tomcat).
 * Configura la aplicación Spring Boot cuando no se ejecuta de forma embebida.
 */
public class ServletInitializer extends SpringBootServletInitializer {

    /**
     * Registra la clase principal de la aplicación en el builder.
     * Permite que el contenedor inicialice el contexto de Spring Boot.
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FitnessSacSpringApplication.class);
    }

}
