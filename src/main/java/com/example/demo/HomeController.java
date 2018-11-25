package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping("/")
    public String index(Model model) {
        Student student = new Student();
        student.setNickname("Jess J");
        student.setRealname("Jessica James");

        Course course= new Course();
        course.setTitle("Intro to Java");
        course.setSemester("Fall");
        course.setDescription("Learning By Coding");

        Set<Course> courses= new HashSet<Course>();
        courses.add(course);

        student.setCourses(courses);

        studentRepository.save(student);

        model.addAttribute("students",studentRepository.findAll());
        return "index";
    }
}
