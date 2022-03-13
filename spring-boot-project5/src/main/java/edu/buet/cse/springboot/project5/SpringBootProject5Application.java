package edu.buet.cse.springboot.project5;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import edu.buet.cse.springboot.project5.entity.Person;
import edu.buet.cse.springboot.project5.jpa.PersonJpaRepository;

@SpringBootApplication
@EntityScan(basePackages = {"edu.buet.cse.springboot.project5.entity"})
public class SpringBootProject5Application implements CommandLineRunner {

  @Autowired
  private PersonJpaRepository personRepository;

  private Logger logger = LogManager.getLogger(getClass());

  public static void main(String[] args) {
    SpringApplication.run(SpringBootProject5Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    List<Person> personList = personRepository.findAll();
    logger.info("all Persons -> {}", personList);

    Person person = personRepository.findById(1L);
    logger.info("Person -> {}", person);

    Person billGates = new Person();
    billGates.setName("Bill Gates");
    billGates.setLocation("USA");
    billGates.setBirthDate(new Date());

    billGates = personRepository.insert(billGates);
    logger.info("New Person -> {}", billGates);

    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, 1955);
    calendar.set(Calendar.MONTH, Calendar.OCTOBER);
    calendar.set(Calendar.DAY_OF_MONTH, 28);
    billGates.setBirthDate(calendar.getTime());

    billGates = personRepository.update(billGates);
    logger.info("Updated Person -> {}", billGates);

    personRepository.deleteById(2L);
    logger.info("Person with id 2 has been removed");
  }
}
