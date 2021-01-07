package edu.buet.cse.springboot.project5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.buet.cse.springboot.project5.jdbc.PersonJdbcDAO;
import edu.buet.cse.springboot.project5.model.Person;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

  @Autowired
  private PersonJdbcDAO jdbcDAO;

  public static void main(String[] args) {
    SpringApplication.run(DatabaseDemoApplication.class, args);
  }

  @Override
  public void run(String... args) {
    Person person = jdbcDAO.findById(10001);
    System.out.println(person);
  }
}
