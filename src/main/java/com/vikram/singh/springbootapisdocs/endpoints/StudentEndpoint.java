package com.vikram.singh.springbootapisdocs.endpoints;

import com.vikram.singh.springbootapisdocs.dto.StudentDto;
import com.vikram.singh.springbootapisdocs.exception.ApiExceptionModel;
import com.vikram.singh.springbootapisdocs.exception.InvalidParametersException;
import com.vikram.singh.springbootapisdocs.exception.ValidatorExceptionModel;
import com.vikram.singh.springbootapisdocs.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Tag(
        name = "Student Endpoints",
        description = "CRUD Rest APIs for students details"
)
public class StudentEndpoint {

    private final StudentService studentService;

    public StudentEndpoint(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(
            summary = "Get one student details using id",
            description = "This Api shows details of one student based on id request parameters",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid Parameters",
                            content = @Content(
                                    schema = @Schema(implementation = ApiExceptionModel.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ApiExceptionModel.class)
                            )
                    )
            }
    )
    @GetMapping("/student-id")
    public ResponseEntity<StudentDto> getStudent(@RequestParam int id) {
        if (id <= 0) throw new InvalidParametersException("Student id is invalid");

        var studentDto = this.studentService.getStudentById(id);
        return ResponseEntity
                .ok()
                .body(studentDto);
    }

    @Operation(
            summary = "Get all student details using id",
            description = "This Api shows details of all student",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ApiExceptionModel.class)
                            )
                    )
            }
    )
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        var studentDtoList = this.studentService.getAllStudents();
        return ResponseEntity.ok(studentDtoList);
    }

    @Operation(
            summary = "Update one student details using id",
            description = "This Api update details of one student based on id path variable and request body",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid Parameters",
                            content = @Content(
                                    schema = @Schema(implementation = ValidatorExceptionModel.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ApiExceptionModel.class)
                            )
                    )
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateStudent(@PathVariable("id") int studentId, @Valid @RequestBody StudentDto studentDto) {
        if (studentId <= 0) throw new InvalidParametersException("Student id is invalid");

        boolean updateStatus = this.studentService.updateStudent(studentDto);
        return ResponseEntity.of(Optional.of(updateStatus));
    }

    @Operation(
            summary = "Add one student details using id",
            description = "This Api add details of one student",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid Parameters",
                            content = @Content(
                                    schema = @Schema(implementation = ValidatorExceptionModel.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ApiExceptionModel.class)
                            )
                    )
            }
    )
    @PostMapping
    public ResponseEntity<?> addStudent(@Valid @RequestBody StudentDto studentDto) {
        this.studentService.addStudent(studentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(
            summary = "Delete one student details using id",
            description = "This Api delete details of one student based on id path variable",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid Parameters",
                            content = @Content(
                                    schema = @Schema(implementation = ApiExceptionModel.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ApiExceptionModel.class)
                            )
                    )
            }
    )
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {
        if (id <= 0) throw new InvalidParametersException("Student id is invalid");

        boolean response = this.studentService.deleteStudent(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
