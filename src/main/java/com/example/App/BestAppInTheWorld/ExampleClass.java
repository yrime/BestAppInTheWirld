package com.example.App.BestAppInTheWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@ComponentScan
public class ExampleClass {

    @Autowired
    private ServiceForJPA jpa;

    public void run() {

        List<Student> students = getStudents();

        students.forEach(student -> {
            jpa.addStudent(student);
        });

        jpa.findAll();
        jpa.findПожалуйстаByEmailIgnoreCaseLike("%.com%");
    }

    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Геннадий", "gena@lena.com", 22));
        students.add(new Student("Инокентий", "hotmashine99@mail.ru", 18));
        students.add(new Student("Мстислав", "example@my.org", 14));
        students.add(new Student("Маргарита", "MaRgO@bk.com", 23));
        students.add(new Student("Гейб", "hl3@valve.com", 110));
        students.add(new Student("Левша", "GodOf@microsoft.com", 23));
        return students;
    }
}
