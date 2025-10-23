package com.example.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "FitnessClub API Equipment",
                version = "1.0.0",
                description = "API для управления оборудованием фитнес-клуба (создание, обновление, удаление, получение данных).",
                contact = @Contact(
                        name = "Катаван Максим",
                        url = "https://github.com/makatt/Fitness-club-API"
                )

        )
)
public class OpenAPIConfig {
}
