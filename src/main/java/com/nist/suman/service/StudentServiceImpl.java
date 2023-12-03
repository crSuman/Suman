package com.nist.suman.service;

import com.nist.suman.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StudentServiceImpl implements StudentService{
    @Autowired
    SessionFactory sessionFactory;


    @Override
    public void saveStudent(Student student) {
        Session session=sessionFactory.getCurrentSession();
        session.save(student);

    }
}
