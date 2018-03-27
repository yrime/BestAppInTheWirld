package com.example.App.BestAppInTheWorld.Repositories;

import com.example.App.BestAppInTheWorld.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    List<Student> findByNameIgnoreCase(String name);

    List<Student> findПожалуйстаByEmailLike(String emailLike);
}
