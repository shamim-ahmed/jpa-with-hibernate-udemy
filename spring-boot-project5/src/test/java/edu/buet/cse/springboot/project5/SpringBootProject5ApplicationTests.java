package edu.buet.cse.springboot.project5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import edu.buet.cse.springboot.project5.entity.Person;
import edu.buet.cse.springboot.project5.jpa.PersonJpaRepository;

@SpringBootTest
public class SpringBootProject5ApplicationTests {

  @Autowired
  private PersonJpaRepository personRepository;

  @Test
  public void testFindAll() {
    List<Person> resultList = personRepository.findAll();
    assertTrue(resultList.size() > 0, "resultList is empty");
  }

  @Test
  public void testFindById() {
    Person person = personRepository.findById(1L);
    assertNotNull(person, "person is null");
    assertEquals("Satoshi Nakamoto", person.getName(), "name is different than expected");
    assertEquals("Japan", person.getLocation(), "location is different than expected");
  }

  @Test
  @DirtiesContext
  public void testInsert() {
    Person person = new Person();
    person.setName("Ranga Karanam");
    person.setLocation("Malaysia");
    person.setBirthDate(new Date());

    assertNull(person.getId(), "id is not null before insertion");
    person = personRepository.insert(person);
    assertNotNull(person.getId(), "id is null after insertion");
  }

  @Test
  @DirtiesContext
  public void testUpdate() {
    Person person = personRepository.findById(3L);
    person.setName("Hayao Miyazaki");

    person = personRepository.update(person);
    assertNotNull(person);
    assertEquals("Hayao Miyazaki", person.getName(), "name is different than expected");
  }
}
