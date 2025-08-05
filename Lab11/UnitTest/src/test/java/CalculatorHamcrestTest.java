import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.closeTo;

import org.example.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorHamcrestTest{
    Calculator calculator=null;

    @BeforeEach
    public void createAcalculator(){
        calculator = new Calculator();
    }

    @Test
    public void add(){
        calculator.add( 50.0);
        assertThat( calculator.getValue(), is (closeTo (50.0, 0.1)));
    }

    @Test
    public void divide(){
        calculator.add( 50.0);
        calculator.divide(4);
        assertThat( calculator.getValue(), is (closeTo (12.5, 0.1)));
    }
}
