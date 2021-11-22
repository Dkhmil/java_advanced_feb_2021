package service;

import dao.Person;
import exception.NoSuchUserException;

public interface PersonService {

    boolean isAuthorized(Person person) throws NoSuchUserException;
}
