import exceptions.NegativesNotAllowedException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator cltr;

    @Before
    public void setUp(){
        cltr = new Calculator();
    }

    @Test
    public void shoudReturnZero() throws NegativesNotAllowedException {
        assertEquals(0, cltr.add(""));
    }

    @Test
    public void shouldReturnOne() throws NegativesNotAllowedException {
        assertEquals(1, cltr.add("1"));
    }

    @Test
    public void shouldReturnThree() throws NegativesNotAllowedException {
        assertEquals(3, cltr.add("1,2"));
    }

    @Test
    public void shouldHandleThreeNumbers() throws NegativesNotAllowedException {
        assertEquals(6, cltr.add("1,2,3"));
    }

    @Test
    public void shouldHandleAnyQuantityOfNumbers() throws NegativesNotAllowedException {
        assertEquals(16, cltr.add("1,2,4,2,7"));
    }

    @Test(expected = NegativesNotAllowedException.class)
    public void shouldThrowNegativeNotAllowedException() throws NegativesNotAllowedException {
        cltr.add("1,-1");

    }
}