package edu.buet.cse.springboot.project6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import edu.buet.cse.springboot.project6.entity.Course;
import edu.buet.cse.springboot.project6.jpa.CourseRepository;

@SpringBootTest
public class SpringBootProject6ApplicationTests {

  @Autowired
  private CourseRepository courseRepository;

  @Test
  public void testFindById() {
    Course course = courseRepository.findById(1L);
    assertTrue(course != null, "course is null");
    assertEquals("Macro-Economics", course.getName(), "Course name is different than expected");
  }
  
  @Test
  @DirtiesContext
  public void testSave() {
    Course course = new Course();
    course.setName("Operations Research");
    
    assertNull(course.getId(), "id is not null before save");
    courseRepository.save(course);
    assertNotNull(course.getId(), "id is null after save");
  }
  
  @Test
  @DirtiesContext
  public void testDeleteById() {
    long id = 2L;
    courseRepository.deleteById(id);
    
    Course course = courseRepository.findById(id);
    assertNull(course, "course is not deleted");
  }
}
