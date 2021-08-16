package Incubyte_StringCalc;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testNullString() {
		assertEquals(0, Calculator.addition(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.addition("1"));
	}

	@Test
	public void testTwoNumbers(){
		assertEquals(3, Calculator.addition("1,2"));
	}

	@Test
    public void testThreeNumbers(){
    	assertEquals(6, Calculator.addition("1,2,3"));
    }

    @Test
    public void testNextLine(){
    	assertEquals(6, Calculator.addition("1\n2,3"));
    }

    @Test
    public void testNegateNumber(){
    	try {
    		Calculator.addition("-1,2");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -1");
		}

		try {
			Calculator.addition("2,-4,3,-5");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -4,-5");
		}
    }

    @Test
    public void testOverAll(){
    	assertEquals(2, Calculator.addition("1000,2"));
    }
    
    @Test
    public void testOtherDelimiter(){
    	assertEquals(3, Calculator.addition("//;\n1;2"));
    }
}
