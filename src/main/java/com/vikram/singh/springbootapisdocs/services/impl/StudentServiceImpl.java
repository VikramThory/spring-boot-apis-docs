package com.vikram.singh.springbootapisdocs.services.impl;

import com.vikram.singh.springbootapisdocs.dto.StudentDto;
import com.vikram.singh.springbootapisdocs.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public StudentDto getStudentById(int id) {
        return null;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return Collections.emptyList();
    }

    @Override
    public boolean updateStudent(StudentDto studentDto) {
        return false;
    }

    @Override
    public void addStudent(StudentDto studentDto) {
    }

    @Override
    public boolean deleteStudent(int id) {
        return false;
    }
}
