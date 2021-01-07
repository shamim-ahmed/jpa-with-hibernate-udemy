package edu.buet.cse.springboot.project5.model;

import java.util.Date;

public class Person {
  private Integer id;
  private String name;
  private String location;
  private Date birthDate;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  @Override
  public String toString() {
    return String.format("[id = %d, name = %s, location = %s, birthDate = %s]", id, name, location,
        birthDate);
  }
}
