package com.nist.suman.service;

import com.nist.suman.model.Student;

import java.util.List;

public interface StudentService {

    public void saveStudent(Student student);
    List<Student> viewStudent();

    public  void deleteStudent(int id);
    public Student getStudentById(int id);
    public  void  updateStudent(Student student);



}
