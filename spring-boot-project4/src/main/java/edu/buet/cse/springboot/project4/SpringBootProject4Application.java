package edu.buet.cse.springboot.project4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import edu.buet.cse.springboot.project4.entity.Person;
import edu.buet.cse.springboot.project4.jpa.PersonJpaRepository;

@SpringBootApplication
@EntityScan(basePackages = {"edu.buet.cse.springboot.project4.entity"})
public class SpringBootProject4Application implements CommandLineRunner {

  @Autowired
  private PersonJpaRepository personRepository;

  private Logger logger = LogManager.getLogger(getClass());

  public static void main(String[] args) {
    SpringApplication.run(SpringBootProject4Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Person person = personRepository.getById(1L);
    logger.info("Person -> {}", person);
  }
}
