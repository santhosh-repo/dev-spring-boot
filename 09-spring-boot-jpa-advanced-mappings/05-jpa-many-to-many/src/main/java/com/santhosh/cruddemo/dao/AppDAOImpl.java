package com.santhosh.cruddemo.dao;

import com.santhosh.cruddemo.entity.Course;
import com.santhosh.cruddemo.entity.Instructor;
import com.santhosh.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor theInstructor = entityManager.find(Instructor.class, theId);

        // get courses
        List<Course> tempCourses = theInstructor.getCourses();

        // break association of all the courses with the instructor
        for (Course course : tempCourses) {
            course.setInstructor(null);
        }

        entityManager.remove(theInstructor);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c where c.instructor.id=:theInstructorId", Course.class);
        query.setParameter("theInstructorId", theId);
        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i JOIN FETCH i.courses " +
                        " JOIN FETCH i.instructorDetail where i.id=:theInstructorId", Instructor.class);
        query.setParameter("theInstructorId", theId);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor theInstructor) {
        entityManager.merge(theInstructor);
    }

    @Override
    @Transactional
    public void update(Course theCourse) {
        entityManager.merge(theCourse);
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        Course course = entityManager.find(Course.class, theId);
        entityManager.remove(course);

    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c " +
                        " JOIN FETCH c.reviews where c.id=:theCourseId", Course.class
        );
        query.setParameter("theCourseId", theId);
        return query.getSingleResult();
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c " +
                        " JOIN FETCH c.students where c.id=:theCourseId", Course.class
        );
        query.setParameter("theCourseId", theId);

        return query.getSingleResult();
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int theId) {
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s " +
                        " JOIN FETCH s.courses where s.id=:theStudentId", Student.class
        );

        query.setParameter("theStudentId", theId);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void deleteStudentById(int theId) {
        Student theStudent = entityManager.find(Student.class, theId);
        entityManager.remove(theStudent);
    }
}
