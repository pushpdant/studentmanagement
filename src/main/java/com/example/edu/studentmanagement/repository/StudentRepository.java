package com.example.edu.studentmanagement.repository;

import com.example.edu.studentmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{
   List<Student>findByFirstName(String name);
   List<Student>findByCollegeName(String cname);
}
