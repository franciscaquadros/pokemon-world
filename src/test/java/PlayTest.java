import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

/**
 * Class that tests the main method in Play class
 */
public class PlayTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayInputStream inContent = new ByteArrayInputStream("NSEOSEONSEO".getBytes());
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
    public void testMainMethod(){

        Play.main(null);

        assertEquals("5", outContent.toString());

    }
}
