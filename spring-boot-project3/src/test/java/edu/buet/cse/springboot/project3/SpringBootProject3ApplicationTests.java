package edu.buet.cse.springboot.project3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.buet.cse.springboot.project3.entity.Person;
import edu.buet.cse.springboot.project3.jdbc.PersonJdbcDao;

@SpringBootTest
public class SpringBootProject3ApplicationTests {

  @Autowired
  private PersonJdbcDao personDao;

  @Test
  public void testFindAll() {
    List<Person> resultList = personDao.findAll();
    assertTrue(resultList.size() > 0, "resultList is empty");
  }

  @Test
  public void testFindById() {
    Person person = personDao.findById(1L);
    assertNotNull(person, "person is null");
    assertEquals("Satoshi Nakamoto", person.getName(), "name is different than expected");
    assertEquals("Japan", person.getLocation(), "location is different than expected");
  }

  @Test
  public void testInsert() {
    Person person = new Person();
    person.setName("Ranga Karanam");
    person.setLocation("Malaysia");
    person.setBirthDate(new Date());

    int n = personDao.insert(person);
    assertEquals(1, n, "person was not created successfully");
  }

  @Test
  public void runUpdate() {
    Person person = personDao.findById(3L);
    assertNotNull(person, "person is null");
    person.setName("Hayao Miyazaki");

    int n = personDao.update(person);
    assertEquals(1, n, "person was not updated successfully");
  }
}
