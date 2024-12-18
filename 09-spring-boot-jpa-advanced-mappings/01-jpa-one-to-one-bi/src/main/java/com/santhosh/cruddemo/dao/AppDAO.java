package com.santhosh.cruddemo.dao;

import com.santhosh.cruddemo.entity.Instructor;

public interface AppDAO {
    public void save(Instructor theInstructor);

    public Instructor findInstructorById(int theId);

    public void deleteInstructorById(int theId);
}
