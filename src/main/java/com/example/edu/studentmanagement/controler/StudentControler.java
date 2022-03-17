package com.example.edu.studentmanagement.controler;

import com.example.edu.studentmanagement.model.Student;
import com.example.edu.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentControler{
    @Autowired
    StudentService studentService;

    @GetMapping("/readall")
    public List<Student> gettallStudent()
    {

        return studentService.getallStudent();
    }
    @GetMapping("/{id}")
    public Student gettIdStudent(@PathVariable Long id)
    {
        Student idstudent =new Student();
        if(id!=null)
        {
            return studentService.gettIdStudent(id);
        }
        return idstudent;
    }


    @GetMapping("/getname")
    public List<Student> gettnameStudentbyFirstName(@RequestParam String name){
        return studentService.gettnameStudentbyName(name);
    }

    @GetMapping("/getcname")
    public List<Student> getcollegeStudentbyName(@RequestParam String cname){
        return studentService.getcollegeStudentbyName(cname);
    }
    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
}

