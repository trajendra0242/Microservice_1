package com.example.studentserviceapp.controller;


import com.example.studentserviceapp.entity.Library;
import com.example.studentserviceapp.entity.Student;
import com.example.studentserviceapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/Student/{id}")
   public Student getStudentById(@PathVariable int id ){
        Library library = restTemplate.getForObject("http://localhost:9092/library/Library/"+id,Library.class);

       Student student = studentService.getStudentByID(id);
       student.setLibrary(library);
       return student;
    }

    @PostMapping("/insert")
    public Student insertStudent(@RequestBody Student student){

        return studentService.insert(student);
    }
}
