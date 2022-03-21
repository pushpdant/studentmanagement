package com.example.edu.studentmanagement.service;

import com.example.edu.studentmanagement.model.Student;
import com.example.edu.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student createStudent(Student student){
        Student newStudent = new Student();
        if(student!=null)
        {
            newStudent= studentRepository.save(student);
        }
        return newStudent;
    }


    public List<Student> getallStudent()
    {
        List<Student> studentlist =studentRepository.findAll();

        if(!studentlist.isEmpty())
        {
            return studentlist;
        }
         return null;
    }

    public Student gettIdStudent(Long id)
    {
        Student onestudent= new Student();
        onestudent=studentRepository.findById(id).orElse(null);

        return onestudent;
    }

    public Student updateStudent(Student student)
    {

        Student existingStudent= new Student();
        if(student!=null) {
            existingStudent = studentRepository.findById(student.getId()).orElse(null);

            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setCollegeName(student.getCollegeName());

            studentRepository.save(existingStudent);
        }
        return existingStudent;

    }
    public List<Student> gettnameStudentbyName(String name)
    {
        List<Student>studentList=studentRepository.findByFirstName(name);
        if(!studentList.isEmpty())
        {
            return studentList;
        } else
        {
            return  null;
        }
    }
    public List<Student> getcollegeStudentbyName(String cname)
    {
        List<Student>studentList=studentRepository.findByCollegeName(cname);
        if(!studentList.isEmpty()){
            return studentList;
        }else {
            return  null;
        }
    }


}

