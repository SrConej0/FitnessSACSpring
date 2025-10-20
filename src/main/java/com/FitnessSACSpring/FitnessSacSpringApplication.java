package com.FitnessSACSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación FitnessSACSpring.
 * Punto de entrada para ejecución embebida (jar) o en pruebas locales.
 */
@SpringBootApplication
public class FitnessSacSpringApplication {

    /**
     * Método de arranque de Spring Boot.
     * Inicializa el contexto y levanta el servidor embebido (Tomcat).
     */
    public static void main(String[] args) {
        SpringApplication.run(FitnessSacSpringApplication.class, args);
    }

}
