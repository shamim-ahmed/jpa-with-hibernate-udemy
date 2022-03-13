package edu.buet.cse.springboot.project4.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import edu.buet.cse.springboot.project4.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {

  @PersistenceContext
  private EntityManager entityManager;

  public List<Person> findAll() {
    TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person p", Person.class);
    return query.getResultList();
  }

  public Person findById(long id) {
    return entityManager.find(Person.class, id);
  }

  public Person insert(Person person) {
    entityManager.persist(person);
    return person;
  }

  public Person update(Person person) {
    return entityManager.merge(person);
  }

  public void deleteById(long id) {
    Person person = findById(id);
    entityManager.remove(person);
  }
}
