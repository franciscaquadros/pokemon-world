import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Class that tests the main method for a case in which
 * there is an invalid input
 */
public class PlayInvalidInputExeptionTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayInputStream inContent = new ByteArrayInputStream("NSAWEONSJEO".getBytes());
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @Before
    public void setUp(){

        System.setIn(inContent);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {

        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    /**
     * Test the main method based on the given input
     */
    public void testMainMethodInvalidInput(){

        Play.main(null);

        assertEquals("Invalid Input! Moves must be N, S, E or O (north, south, east and west, respectively)", outContent.toString());

    }
}
