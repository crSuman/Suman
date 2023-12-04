package com.nist.suman.controller;

import com.nist.suman.model.Student;
import com.nist.suman.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;


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

    @RequestMapping("/submit")
    public ModelAndView submit(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        ModelAndView modelAndView = new ModelAndView("StudentDetails");
        List<Student> studentList = studentService.viewStudent();
        modelAndView.addObject("studentKey", studentList);
        return modelAndView;

    }
    @RequestMapping("/studentDetail")
    public ModelAndView viewStudent(){
        ModelAndView modelAndView=new ModelAndView("StudentDetails");
        List<Student> studentList=studentService.viewStudent();
        modelAndView.addObject("studentKey",studentList);
        return modelAndView;
    }

    @RequestMapping("/deleteUser")
    public ModelAndView deleteStudent(@RequestParam("id")int id){
        studentService.deleteStudent(id);
        ModelAndView modelAndView=new ModelAndView("StudentDetails");
        List<Student> studentList=studentService.viewStudent();
        modelAndView.addObject("studentKey",studentList);
        return modelAndView;
    }



    @RequestMapping("/editUser")
    public ModelAndView editStudent(@RequestParam("id")int id){
        Student studentList=studentService.getStudentById(id);
        ModelAndView modelAndView=new ModelAndView("Login");
        modelAndView.addObject("studentKey",studentList);
        return modelAndView;
    }

}
