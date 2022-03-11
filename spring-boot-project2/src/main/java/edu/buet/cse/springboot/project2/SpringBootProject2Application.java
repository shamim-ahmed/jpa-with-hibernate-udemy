package edu.buet.cse.springboot.project2;

import java.util.Calendar;
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
    // find all persons
    List<Person> allPersonList = jdbcDao.findAll();
    logger.info("All persons -> {}", allPersonList);

    // find Person with a specific id
    Person person = jdbcDao.findById(1L);
    logger.info("Person with id 1 -> {}", person);

    // find all Person objects with a specific location
    List<Person> usaPersonList = jdbcDao.findByLocation("USA");
    logger.info("Person with location USA -> {}", usaPersonList);

    // delete a Person with specific id
    long id = 2L;
    logger.info("Deleting Person with id {}...", id);
    logger.info("No of rows deleted -> {}", jdbcDao.deleteById(id));

    // create new Person
    Person billGates = new Person();
    billGates.setName("Bill Gates");
    billGates.setLocation("USA");
    billGates.setBirthDate(new Date());
    logger.info("No of rows inserted -> {}", jdbcDao.insert(billGates));    

    // update date of birth for person with id = 1
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, 1974);
    calendar.set(Calendar.MONTH, Calendar.NOVEMBER);
    calendar.set(Calendar.DAY_OF_MONTH, 28);
    person.setBirthDate(calendar.getTime());

    logger.info("No of rows updated -> {}", jdbcDao.update(person));
  }
}
