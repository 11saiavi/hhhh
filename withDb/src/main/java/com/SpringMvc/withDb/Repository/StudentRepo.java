package com.SpringMvc.withDb.Repository;

import com.SpringMvc.withDb.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {

    List<Student> findByAge(int age);

    List<Student> findBySection(String section);
}
