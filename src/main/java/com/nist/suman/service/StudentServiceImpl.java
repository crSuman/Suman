package com.nist.suman.service;

import com.nist.suman.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class StudentServiceImpl implements StudentService{
    @Autowired
    SessionFactory sessionFactory;


    @Override
    public void saveStudent(Student student) {
        Session session=sessionFactory.getCurrentSession();
        session.save(student);

    }

    @Override
    public List<Student> viewStudent() {
        Session session=sessionFactory.getCurrentSession();
        List<Student> studentList=session.createCriteria(Student.class).list();
        return studentList;
    }

    @Override
    public void deleteStudent(int id) {
        Session session=sessionFactory.getCurrentSession();
        Student student=session.get(Student.class,id);
        if (student!=null){
            session.delete(student);
        }

    }

    @Override
    public Student getStudentById(int id) {
        Session session=sessionFactory.getCurrentSession();
        Student student=session.get(Student.class,id);
        return student;
    }

    @Override
    public void updateStudent(Student student) {
        Session session=sessionFactory.getCurrentSession();
        Student student1=session.get(Student.class,student.getId());
        if (student1!=null){
            student1.setName(student.getName());
            student1.setEmail(student.getEmail());
            student1.setPassword(student.getPassword());
            session.update(student1);
        }

    }


}
