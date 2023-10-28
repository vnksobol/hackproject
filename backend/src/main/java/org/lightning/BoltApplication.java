package org.lightning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * 
 * @author Marina Kotuseva
 */
@SpringBootApplication
public class BoltApplication {

    public static void main(String[] args) {

        SpringApplication.run(BoltApplication.class, args);
    }

    // Для локальной демонстрации в целях экономии времени зададим прямо тут бины

    @Bean
    public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/questions").allowedOrigins("http://localhost:63342");
                registry.addMapping("/questions").allowedOrigins("http://127.0.0.1:5500");
                registry.addMapping("/create").allowedOrigins("http://localhost:63342");
                registry.addMapping("/create").allowedOrigins("http://127.0.0.1:5500");
            }
        };
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:63342");
        configuration.addAllowedOrigin("http://127.0.0.1:5500");
        configuration.addAllowedMethod("DELETE");
        configuration.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/questions/{id}", configuration);

        return source;
    }
}
