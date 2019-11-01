import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pt.pokemonworld.view.PokemonWorldView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


/**
 * This class contains a test to check that the result
 * will be printed as expected
 */
public class PokemonWorldViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private PokemonWorldView pokemonWorldView;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        pokemonWorldView = new PokemonWorldView();
    }

    @After
    public void restoreStream() {
        System.setOut(originalOut);
    }

    @Test
    public void outTester() {

        pokemonWorldView.printResult(5);

        assertEquals("5", outContent.toString());
    }
}
