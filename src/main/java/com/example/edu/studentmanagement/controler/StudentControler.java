package com.example.edu.studentmanagement.controler;

import com.example.edu.studentmanagement.model.Student;
import com.example.edu.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentControler{
    @Autowired
    StudentService studentService;

    @GetMapping("/readall")
    public String gettallStudent(Model model)
    {
        model.addAttribute("students",studentService.getallStudent());
        return "list-student";
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
    public String createStudent(@ModelAttribute Student student){

        studentService.createStudent(student);
        return "redirect:/student/readall";
    }

    @GetMapping("/add")
    public String showAddStudentForm(@ModelAttribute Student student){
        return "add-student";
    }

    @GetMapping("/edit/{id}")
    public String updateStudentForm(@PathVariable ("id")Long id, Model model )
    {

        model.addAttribute("student",studentService.gettIdStudent(id));
        return "update-student";
    }
    @PostMapping("/edit")
    public String edStudentForm(@ModelAttribute Student student)
    {

        return "redirect:/student/readall";
    }
}

