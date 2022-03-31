package com.example.CRUAPIPOSTGESQL.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentEntity> getStudent(){
        return studentRepository.findAll();
    }

    public void createStudent(StudentEntity student){
        studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        boolean exists = studentRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException(
                    "Studenet with id" + id + "does not exist"
            );
        }

        studentRepository.deleteById(id);
    }

    public void updateStudent(Long id, String name, String email){
        StudentEntity student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student with id" + id + "does not exist"));

        if(name != null && name.length() >0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(),email)){
            student.setEmail(email);
        }
    }


}
