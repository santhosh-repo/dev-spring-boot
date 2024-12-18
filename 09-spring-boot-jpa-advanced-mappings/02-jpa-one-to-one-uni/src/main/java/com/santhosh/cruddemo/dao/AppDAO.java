package com.santhosh.cruddemo.dao;

import com.santhosh.cruddemo.entity.Instructor;
import com.santhosh.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    public void save(Instructor theInstructor);

    public Instructor findInstructorById(int theId);

    public void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
}
