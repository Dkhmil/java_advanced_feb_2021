package service;

import dao.Person;
import exception.NoSuchUserException;
import lombok.AllArgsConstructor;

import java.util.List;

public class PersonServiceImp implements PersonService {

    private List<Person> personList;

    public PersonServiceImp(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public boolean isAuthorized(Person person) throws NoSuchUserException {
        Person fromList = personList.stream().filter((p) -> p.getName().equals(person.getName())).findFirst()
                .orElseThrow(() -> new NoSuchUserException("No such user!"));
        return person.getEmail().equals(fromList.getEmail()) && person.getPassword().equals(fromList.getPassword());
    }
}
