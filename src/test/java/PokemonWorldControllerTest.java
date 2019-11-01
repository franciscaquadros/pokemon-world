import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pt.pokemonworld.controller.PokemonWorldController;
import pt.pokemonworld.exceptions.InvalidInputException;
import pt.pokemonworld.model.PokemonWorld;
import pt.pokemonworld.view.PokemonWorldView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Class to test all the methods of the controller
 */
public class PokemonWorldControllerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private PokemonWorld pokemonWorld;
    private PokemonWorldView pokemonWorldView;
    private PokemonWorldController pokemonWorldController;

    @Before
    public void setUp() {

        System.setOut(new PrintStream(outContent));
        pokemonWorld = new PokemonWorld();
        pokemonWorldView = new PokemonWorldView();
        pokemonWorldController = new PokemonWorldController(pokemonWorld, pokemonWorldView);

    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    /**
     * Test the ShowView method in a normal scenario
     */
    public void showViewTester(){

        pokemonWorld.setPokemonsCatched(110);
        pokemonWorldController.showView();

        assertEquals("110", outContent.toString());
    }

    @Test
    /**
     * Test the method calculatePokemonsCatched with a normal set of moves
     */
    public void calculatePokemonsCatchedTester() throws Exception{

        pokemonWorld.initDefault();
        String moves = "NSEOENSEOSSSNOEOOEN";


        pokemonWorldController.calculatePokemonsCatched(moves);

        assertEquals(11, pokemonWorld.getPokemonsCatched());
    }

    @Test
    /**
     * Test the method calculatePokemonsCatched with a bigger set of moves
     */
    public void calculatePokemonsCatchedBigMoveTester(){

        pokemonWorld.initDefault();
        String bigMove = "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS";

        try{
            pokemonWorldController.calculatePokemonsCatched(bigMove);
        }catch (Exception ex){

        }

        assertEquals(bigMove.length() + 1, pokemonWorld.getPokemonsCatched());
    }

    @Test
    /**
     * Test the method calculatePokemonsCatched with a big set of repeated moves
     */
    public void calculatePokemonsCatchedRepeatedMovesTester() throws Exception{

        pokemonWorld.initDefault();
        StringBuilder moves = new StringBuilder();

        for(int i=0; i<1000000; i++){
            moves.append("NS");
        }

        String bigRepeatedMove = moves.toString();


        pokemonWorldController.calculatePokemonsCatched(bigRepeatedMove);


        assertEquals(2, pokemonWorld.getPokemonsCatched());
    }

    @Test(expected = InvalidInputException.class)
    /**
     * Test the method calculatePokemonsCatched with input that contains non valid characters
     */
    public void calculatePokemonsCatchedInvalidInputTester() throws Exception{

        pokemonWorld.initDefault();
        String invalidInput = "ABCNSEO";


        pokemonWorldController.calculatePokemonsCatched(invalidInput);

    }
}