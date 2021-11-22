package com.SpringMvc.withDb.Controller;


import com.SpringMvc.withDb.Model.Student;
import com.SpringMvc.withDb.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> get(@RequestParam(required = false) Long id) {
        try {
            List<Student> student = new ArrayList<Student>();

            if (id == null)
                studentRepo.findAll().forEach(student::add);

            if (student.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long id) {
        Optional<Student> studentData = studentRepo.findById(id);

        if (studentData.isPresent()) {
            return new ResponseEntity<>(studentData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
