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
    public void shoudReturnZero(){
        assertEquals(0, cltr.add(""));
    }

    @Test
    public void shouldReturnOne(){
        assertEquals(1, cltr.add("1"));
    }

    @Test
    public void shouldReturnThree(){
        assertEquals(3, cltr.add("1,2"));
    }

    @Test
    public void shouldHandleThreeNumbers(){
        assertEquals(6, cltr.add("1,2,3"));
    }

    @Test
    public void shouldHandleAnyQuantityOfNumbers(){
        assertEquals(16, cltr.add("1,2,4,2,7"));
    }
}