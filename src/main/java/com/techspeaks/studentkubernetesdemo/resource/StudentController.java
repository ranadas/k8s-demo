package com.techspeaks.studentkubernetesdemo.resource;

import com.techspeaks.studentkubernetesdemo.entity.Student;
import com.techspeaks.studentkubernetesdemo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/student-records")
public class StudentController {

    private final StudentRepository studentRepository;

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student){
        log.info("Saving a new student");
        Student student1 = studentRepository.save(student);
        return student1;
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        log.info("Retrieving all students");
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Optional<Student> getStudent(@PathVariable("id") Integer id){
        log.info("Retrieving student by id");
        return studentRepository.findById(id);
    }

    @DeleteMapping("/student/delete/{id}")
    public void deleteStudent(@PathVariable("id") Integer id){
        log.info("Deleting student by id");
        studentRepository.deleteById(id);
    }
}
