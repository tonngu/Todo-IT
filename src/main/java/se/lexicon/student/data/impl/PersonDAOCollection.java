package se.lexicon.student.data.impl;

import se.lexicon.student.data.PersonDao;
import se.lexicon.student.data.sequencer.PersonIdSequencer;
import se.lexicon.student.model.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonDAOCollection implements PersonDao {
    private List<Person> storage = new ArrayList<>();

    @Override
    public Person persist(Person person) {
        if (person == null) throw new IllegalArgumentException("Person Data cannot be null");
        int id = PersonIdSequencer.nextId();
        person.setId(id);
        storage.add(person);
        return person;
    }

    @Override
    public Person findById(int id) {
        for (Person person : storage) {
            if (person.getId() == id) {
                return person;
            }
        }
        System.out.println("Person not found");
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        for (Person person : storage) {
            if (person.getEmail().equals(email)) {
                return person;
            }
        }
        System.out.println("Person not found");
        return null;
    }

    @Override
    public Collection<Person> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void remove(int id) {
        storage.remove(findById(id));
    }


}
