import exception.CannotDivideIntoNullException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import service.Calculations;
import service.CalculationsImpl;

public class CalculationsImplTest {

    private Calculations calculations;

    @BeforeEach
    public void init() {
        calculations = new CalculationsImpl();
    }

    @Test
    @DisplayName("Test suma method")
    public void sumaTest() {
        double actual = calculations.suma(2, 45);
        double expected = 47;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test minus method")
    public void minusTest() {
        double actual = calculations.minus(2, 45);
        double expected = -43;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test multiply method")
    public void multiplyTest() {
        double actual = calculations.multiply(2, 45);
        double expected = 90;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test divide method -- success case")
    public void divideTest() throws CannotDivideIntoNullException {
        double actual = calculations.divide(46, 23);
        double expected = 2;
        Assertions.assertEquals(expected, actual);
    }


    @ParameterizedTest(name = "a={0}, b={1}, result={2}")
    @CsvSource({
            "12, 3, 4",
            "45, 5, 9"
    })
    @DisplayName("Test divide method -- success case parametrized")
    public void divideTestParametrized(double n1, double n2, double expected) throws CannotDivideIntoNullException {
        double actual = calculations.divide(n1, n2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test divide method -- exception case")
    public void divideTestShouldThrowException() {
        Assertions.assertThrows(CannotDivideIntoNullException.class, () -> calculations.divide(46, 0));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15})
    @DisplayName("Test if number is positive")
    public void isPositiveTest(int number){
        Assertions.assertTrue(calculations.isPositive(number));
    }

    @Test
    @DisplayName("Test if number is negative")
    public void isPositiveTestWhenNumberIsNegative(){
        Assertions.assertFalse(calculations.isPositive(-566.233));
    }

    @AfterEach
    public void testFinished() {
        System.out.println("Test was finished!");
    }

    @AfterAll
    static void end() {
        System.out.println("---- End ----");
    }
}
