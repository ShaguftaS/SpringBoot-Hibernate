package com.springbootcode.cruddemo.dao;

import com.springbootcode.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

}
