package edu.buet.cse.springboot.project2;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.buet.cse.springboot.project2.entity.Person;
import edu.buet.cse.springboot.project2.jdbc.PersonJdbcDao;

@SpringBootApplication
public class SpringBootProject2Application implements CommandLineRunner {

  private Logger logger = LogManager.getLogger(getClass());

  @Autowired
  private PersonJdbcDao jdbcDao;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootProject2Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    List<Person> resultList = jdbcDao.findAll();
    logger.info("All users -> {}", resultList);
  }
}
