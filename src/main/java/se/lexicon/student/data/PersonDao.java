package se.lexicon.student.data;

import se.lexicon.student.model.Person;

import java.util.Collection;

public interface PersonDao {
    Person persist(Person person);
    Person findById(int id);
    Person findByEmail(String email);
    Collection<Person> findAll();
    void remove(int id);
}
