package edu.buet.cse.springboot.project6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.buet.cse.springboot.project6.entity.Course;
import edu.buet.cse.springboot.project6.jpa.CourseRepository;

@SpringBootTest
class SpringBootProject6ApplicationTests {

  @Autowired
  private CourseRepository courseRepository;

  @Test
  void testFindById() {
    Course course = courseRepository.findById(1L);
    assertTrue(course != null, "course is null");
    assertEquals("Macro-Economics", course.getName(), "Course name is different than expected");
  }
}
