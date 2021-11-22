import dao.Person;
import exception.NoSuchUserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.PersonService;
import service.PersonServiceImp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PersonServiceImpTest {

    private static PersonService service;

    @BeforeAll
    static void init() {
        service = new PersonServiceImp(createTestList());
    }

    @Test
    @DisplayName("Test isAuthorized user -> success")
    public void isAuthorizedTest() throws NoSuchUserException {
        Assertions.assertTrue(service.isAuthorized(new Person("Lala", "lalala@gmail.com", "paww1230",
                new Date(1992, Calendar.MAY, 12))));
    }

    @Test
    @DisplayName("Test isAuthorized user -> with exception")
    public void isAuthorizedTestWithException() {
        Assertions.assertThrows(NoSuchUserException.class, () -> service.isAuthorized(new Person("Petro", "lalala@gmail.com", "pawrrw1230",
                new Date(1992, Calendar.MAY, 12))));
    }

    private static List<Person> createTestList() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Anna", "lalala@gmail.com", "paww1230", new Date(1992, Calendar.MAY, 12)));
        people.add(new Person("Lala", "lalala@gmail.com", "paww1230", new Date(1992, Calendar.MAY, 12)));
        people.add(new Person("Lily", "lalala@gmail.com", "paww1230", new Date(1992, Calendar.MAY, 12)));
        return people;
    }
}
