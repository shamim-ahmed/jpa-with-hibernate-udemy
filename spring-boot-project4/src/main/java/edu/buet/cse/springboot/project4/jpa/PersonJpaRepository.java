package edu.buet.cse.springboot.project4.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import edu.buet.cse.springboot.project4.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {

  @PersistenceContext
  private EntityManager entityManager;

  public Person getById(long id) {
    return entityManager.find(Person.class, id);
  }
}
