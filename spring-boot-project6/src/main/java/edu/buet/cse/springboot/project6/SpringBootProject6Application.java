package edu.buet.cse.springboot.project6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.buet.cse.springboot.project6.entity.Course;
import edu.buet.cse.springboot.project6.jpa.CourseRepository;

@SpringBootApplication
public class SpringBootProject6Application implements ApplicationRunner {

  private final Logger logger = LogManager.getLogger(getClass());

  @Autowired
  private CourseRepository courseRepository;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootProject6Application.class, args);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Course course = courseRepository.findById(1L);
    logger.info("Course with id 1 -> {}", course);
  }
}
