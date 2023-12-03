package com.nist.suman.controller;

import com.nist.suman.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {


    @RequestMapping("/login")
    public ModelAndView showLogin() {
        ModelAndView modelAndView = new ModelAndView("Login");
        return modelAndView;
    }

    @RequestMapping("/navbar")
    public ModelAndView showNavbar() {
        ModelAndView modelAndView = new ModelAndView("Navbar");
        return modelAndView;
    }

    @RequestMapping("/signin")
    public ModelAndView showSignin() {
        ModelAndView modelAndView = new ModelAndView("Signin");
        return modelAndView;
    }

    @RequestMapping("/signup")
    public ModelAndView showSignup() {
        ModelAndView modelAndView = new ModelAndView("Signup");
        return modelAndView;
    }

    @RequestMapping("/save")
    public ModelAndView saveStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        ModelAndView modelAndView = new ModelAndView("StudentDetails");
        List<Student> studentList = studentService.viewStudent();
        modelAndView.addObject("studentKey", studentList);
        return modelAndView;


    }
}
