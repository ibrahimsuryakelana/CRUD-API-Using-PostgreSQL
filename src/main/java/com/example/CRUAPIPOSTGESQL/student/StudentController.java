package com.example.CRUAPIPOSTGESQL.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentEntity> getStudent(){
        return studentService.getStudent();
    }

    @PostMapping
    public void createStudent(@RequestBody StudentEntity student){
        studentService.createStudent(student);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping("{id}")
    public void updateStudent(@PathVariable("id") Long id, @RequestParam(required=false) String name, String email){
        studentService.updateStudent(id,name, email);
    }
}
