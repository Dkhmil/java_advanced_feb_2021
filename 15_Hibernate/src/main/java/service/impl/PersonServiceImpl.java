package service.impl;

import model.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.PersonService;
import util.SessionFactoryUtil;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    private final Session session;
    private final Transaction transaction;

    public PersonServiceImpl() {
        this.session = SessionFactoryUtil.getSession();
        this.transaction = session.beginTransaction();
    }

    public Person read(int id) {
        return session.get(Person.class, id);
    }

    public List<Person> readAll() {
        return session.createCriteria(Person.class).list();
    }

    public void create(Person person) {
        session.persist(person);
        transaction.commit();
    }

    public void update(Person person) {
        Person p = read(person.getId());
        p.setAge(p.getAge());
        p.setFirstName(p.getFirstName());
        p.setLastName(p.getLastName());
        session.persist(p);
        transaction.commit();
    }

    public void delete(int id) {
        Person person = read(id);
        session.delete(person);
        transaction.commit();
    }
}
