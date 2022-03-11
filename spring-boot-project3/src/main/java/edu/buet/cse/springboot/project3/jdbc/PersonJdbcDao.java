package edu.buet.cse.springboot.project3.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.buet.cse.springboot.project3.entity.Person;

@Repository
public class PersonJdbcDao {

  public static final String SELECT_ALL_PERSON_QUERY = "SELECT * FROM Person";

  private static final String SELECT_PERSON_BY_ID_QUERY = "SELECT * FROM Person WHERE id = ?";

  private static final String SELECT_PERSON_BY_LOCATION_QUERY =
      "SELECT * FROM Person WHERE location = ?";

  private static final String DELETE_PERSON_BY_ID_QUERY = "DELETE FROM Person WHERE id = ?";

  private static final String INSERT_PERSON_QUERY =
      "INSERT INTO PERSON (name, location, birth_date) VALUES (?, ?, ?)";

  private static final String UPDATE_PERSON_QUERY =
      "UPDATE Person SET name = ?, location = ?, birth_date = ? WHERE id = ?";

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public List<Person> findAll() {
    return jdbcTemplate.query(SELECT_ALL_PERSON_QUERY, new PersonRowMapper());
  }

  public Person findById(int id) {
    return jdbcTemplate.queryForObject(SELECT_PERSON_BY_ID_QUERY,
        new PersonRowMapper(), new Object[] {id});
  }

  public List<Person> findByLocation(String location) {
    return jdbcTemplate.query(SELECT_PERSON_BY_LOCATION_QUERY,
        new PersonRowMapper(), new Object[] {location});
  }

  public int deleteById(int id) {
    return jdbcTemplate.update(DELETE_PERSON_BY_ID_QUERY, new Object[] {id});
  }

  public int insert(Person person) {
    return jdbcTemplate.update(INSERT_PERSON_QUERY,
        new Object[] {person.getName(), person.getLocation(), person.getBirthDate()});
  }

  public int update(Person person) {
    return jdbcTemplate.update(UPDATE_PERSON_QUERY, new Object[] {person.getName(),
        person.getLocation(), person.getBirthDate(), person.getId()});
  }
}
