//Vincent Pham 03/27/2023


package application;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class MyHandlerTest {
	
	 public String handle(List<String> input) {
	        StringBuilder sb = new StringBuilder();
	        for (String str : input) {
	            sb.append(str);
	        }
	        return sb.toString();
	    }

    @Test
    public void testHandle() {
        // Arrange
        MyHandlerTest handler = new MyHandlerTest();
        List<String> input = new ArrayList<>();
        input.add("hello");
        input.add("world");

        // Act
        String result = handler.handle(input);

        // Assert
        assertEquals("helloworld", result);
    }
}
