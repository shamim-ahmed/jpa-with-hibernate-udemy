package edu.buet.cse.springboot.project6.jpa;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.buet.cse.springboot.project6.entity.Course;

@Repository
public class CourseRepository {
  @Autowired
  private EntityManager entityManager;

  public Course findById(long id) {
    return entityManager.find(Course.class, id);
  }

  public Course save(Course course) {
    return entityManager.merge(course);
  }

  public void deleteById(long id) {
    Course course = findById(id);

    if (course != null) {
      entityManager.remove(course);
    }
  }
}
