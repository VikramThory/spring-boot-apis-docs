package com.vikram.singh.springbootapisdocs.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Schema(
        name = "ErrorResponse",
        description = "Schema to hold error response information"
)
public record ApiExceptionModel(
        @Schema(description = "Error message")
        String message,
        @Schema(description = "Error code")
        HttpStatus httpStatus,
        @Schema(description = "Error time")
        ZonedDateTime timestamp) {
}
