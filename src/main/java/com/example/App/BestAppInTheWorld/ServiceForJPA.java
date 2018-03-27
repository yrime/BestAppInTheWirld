package com.example.App.BestAppInTheWorld;

import com.example.App.BestAppInTheWorld.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@ComponentScan
public class ServiceForJPA {

    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(Student student) {
        Student result = studentRepository.save(student);
        if(result == null) {
            printMessage("All bad");
        }
        printMessage("Ok");
    }

    public void findAll() {
        Iterable<Student> students = studentRepository.findAll();
        printStudentInConsole(students);
    }

    public void deleteAll() {
        studentRepository.deleteAll();
        findAll();
    }

    public void findByName(String name) {
        List<Student> result = studentRepository.findByNameIgnoreCase(name);
        if(result == null) {
            printMessage("Its bad");
            return;
        } else {
            printStudentInConsole(result);
            printMessage("Ok");
        }
    }

    public void findПожалуйстаByEmailIgnoreCaseLike(String emailLike) {
        List<Student> result = studentRepository.findПожалуйстаByEmailLike(emailLike);
        if(result == null) {
            printMessage("Its bad");
            return;
        } else {
            printStudentInConsole(result);
            printMessage("Ok");
        }
    }

    private void printStudentInConsole(Student student) {
        int maxFieldLen = 20;
        Integer id = student.getId();
        String name = student.getName();
        String email = student.getEmail();
        Integer age = student.getAge();

        int lenName = name.length();
        int lenMail = email.length();
        int lenId = getLenNumber(student.getId());
        int lenAge = getLenNumber(student.getAge());

        // TODO переделать
        List<String> dataString = Arrays.asList(Integer.toString(id), name, email
            , Integer.toString(age));
        int max = Arrays.asList(lenAge, lenId, lenMail, lenName).stream()
            .max(Integer::compareTo).get();

        if(maxFieldLen < max) {
            maxFieldLen = max;
        }

        String stringOut = "";
        for(int i = 0;i<4;i++) {
            String data = dataString.get(i);
            stringOut = stringOut + "| " + data;
            for(int j = 0; j< maxFieldLen - data.length(); j++) {
                stringOut = stringOut + " ";
            }
        }
        System.out.println(stringOut);
    }

    private void printStudentInConsole(Iterable<Student> students) {
        System.out.println("| ID                  | Name                | Email               | Age  ");
        System.out.println("--------------------------------------------------------------------------");
        for(Student item: students) {
            printStudentInConsole(item);
        }
        System.out.println("");
    }

    private int getLenNumber(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    private void printMessage(String message) {
        System.out.println("Message: " + message);
    }
}
