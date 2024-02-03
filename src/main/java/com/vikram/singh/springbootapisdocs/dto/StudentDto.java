package com.vikram.singh.springbootapisdocs.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Schema(
        name = "Student",
        description = "Schema to hold Student information"
)
public record StudentDto(@NotEmpty(message = "Student name can not be empty")
                         @Size(min = 1, max = 30, message = "The length of Student name should be between 1 to 30")
                         @Schema(
                                description = "Name of Student",
                                example = "Student1"
                         )
                         String name,
                         @Schema(
                                 description = "Standard/Class of Student",
                                 example = "11"
                         )
                         int standard,
                         @NotEmpty(message = "Student section can not be empty")
                         @Schema(
                                 description = "Class Section of Student",
                                 example = "A"
                         )
                         String section) {
}
