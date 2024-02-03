package com.vikram.singh.springbootapisdocs.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Test User / Department",
                        email = "test@email.com",
                        url = "https://github.com/VikramThory"
                ),
                description = "Example API documentation using Spring Open API Docs",
                title = "Spring Boot Open API Example",
                version = "1.0",
                license = @License(
                        name = "OpenSource",
                        url = "https://github.com/VikramThory"
                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Local Environment",
                        url = "http://localhost:8081/api/v1"
                )
        }
)
public class OpenApiConfiguration {
}
