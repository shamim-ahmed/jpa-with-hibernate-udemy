package edu.buet.cse.springboot.project3.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.buet.cse.springboot.project3.entity.Person;

/**
 * Custom row mapper for Person
 * 
 * @author shamim
 */
public class PersonRowMapper implements RowMapper<Person> {

  @Override
  public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
    Person person = new Person();
    person.setId(rs.getLong("id"));
    person.setName(rs.getString("name"));
    person.setLocation(rs.getString("location"));
    person.setBirthDate(rs.getDate("birth_date"));

    return person;
  }
}
