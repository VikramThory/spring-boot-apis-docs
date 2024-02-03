package com.vikram.singh.springbootapisdocs.services;

import com.vikram.singh.springbootapisdocs.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto getStudentById(int id);

    List<StudentDto> getAllStudents();

    boolean updateStudent(StudentDto studentDto);

    void addStudent(StudentDto studentDto);

    boolean deleteStudent(int id);
}
