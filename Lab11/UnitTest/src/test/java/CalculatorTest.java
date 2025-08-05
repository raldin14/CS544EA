import org.example.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setup(){
        calculator = new Calculator();
    }

    @Test
    public void testInitialization() {
        assertEquals(0.0, calculator.getValue(),0.0000001);
    }

    @Test
    public void testAddZero() {
        calculator.add(0.0);
        assertEquals(0.0, calculator.getValue(),0.0000001);
    }

}
