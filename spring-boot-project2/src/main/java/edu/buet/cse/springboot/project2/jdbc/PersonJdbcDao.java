package edu.buet.cse.springboot.project2.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.buet.cse.springboot.project2.entity.Person;

@Repository
public class PersonJdbcDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public List<Person> findAll() {
    return jdbcTemplate.query("SELECT * FROM Person",
        new BeanPropertyRowMapper<Person>(Person.class));
  }
}
