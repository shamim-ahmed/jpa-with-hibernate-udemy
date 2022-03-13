package edu.buet.cse.springboot.project6.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.buet.cse.springboot.project6.entity.Course;

@Repository
@Transactional
public class CourseRepository {

  @PersistenceContext
  private EntityManager entityManager;

  public Course findById(long id) {
    return entityManager.find(Course.class, id);
  }

  public Course save(Course course) {
    if (course.getId() == null) {
      entityManager.persist(course);
      return course;
    }

    return entityManager.merge(course);
  }

  public void deleteById(long id) {
    Course course = findById(id);

    if (course != null) {
      entityManager.remove(course);
    }
  }
}
