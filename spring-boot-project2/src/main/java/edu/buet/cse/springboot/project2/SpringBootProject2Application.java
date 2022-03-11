package edu.buet.cse.springboot.project2;

import java.util.Date;
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
    List<Person> allPersonList = jdbcDao.findAll();
    logger.info("All persons -> {}", allPersonList);

    Person person = jdbcDao.findById(1);
    logger.info("Person with id 1 -> {}", person);

    List<Person> usaPersonList = jdbcDao.findByLocation("USA");
    logger.info("Person with location USA -> {}", usaPersonList);
    
    int id = 2;
    logger.info("Deleting Person with id {}...", id);
    logger.info("No of rows deleted -> {}", jdbcDao.deleteById(id));
    
    Person billGates = new Person();
    billGates.setName("Bill Gates");
    billGates.setLocation("USA");
    billGates.setBirthDate(new Date());
    logger.info("No of rows inserted -> {}", jdbcDao.insert(billGates));
  }
}
