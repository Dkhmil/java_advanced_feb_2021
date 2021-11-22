import dao.Person;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Anna", "lalala@gmail.com", "paww1230",
                new Date(1992, Calendar.MAY, 12));
    }
}
