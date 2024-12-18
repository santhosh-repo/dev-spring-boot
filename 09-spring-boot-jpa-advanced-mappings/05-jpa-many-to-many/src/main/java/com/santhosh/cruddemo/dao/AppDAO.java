package com.santhosh.cruddemo.dao;

import com.santhosh.cruddemo.entity.Course;
import com.santhosh.cruddemo.entity.Instructor;
import com.santhosh.cruddemo.entity.Student;

import java.util.List;

public interface AppDAO {
    public void save(Instructor theInstructor);

    public Instructor findInstructorById(int theId);

    public void deleteInstructorById(int theId);

    public List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor theInstructor);

    void update(Course theCourse);

    Course findCourseById(int theId);

    void deleteCourseById(int theId);

    void save(Course theCourse);

    Course findCourseAndReviewsByCourseId(int theId);

    Course findCourseAndStudentsByCourseId(int theId);

    Student findStudentAndCoursesByStudentId(int theId);

    void update(Student theStudent);

    void deleteStudentById(int theId);

}
