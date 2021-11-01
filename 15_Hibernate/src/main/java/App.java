import model.Person;
import service.PersonService;
import service.impl.PersonServiceImpl;

public class App {

    public static void main(String[] args) {
        PersonService service = new PersonServiceImpl();
        service.create(new Person("Ivan", "Ivanenko", 30));
    }
}
