package com.vikram.singh.springbootapisdocs.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.Map;

@Schema(
        name = "Validator ErrorResponse",
        description = "Schema to hold error response information"
)
public record ValidatorExceptionModel(
        @Schema(description = "Error message")
        Map<String, String> message,
        @Schema(description = "Error code")
        HttpStatus httpStatus,
        @Schema(description = "Error time")
        ZonedDateTime timestamp) {
}
