import org.junit.Before;
import org.junit.Test;
import pt.pokemonworld.controller.PokemonWorldController;
import pt.pokemonworld.model.Coordinates;
import pt.pokemonworld.model.PokemonWorld;
import pt.pokemonworld.view.PokemonWorldView;

import static org.junit.Assert.assertEquals;

/**
 * This class holds some tests to check the method
 * that sums the coordinates
 */
public class CoordinatesTest {

    private PokemonWorld pokemonWorld;
    private PokemonWorldView pokemonWorldView;
    private Coordinates originalCoordinates;
    private PokemonWorldController pokemonWorldController;

    @Before
    public void setup(){
        pokemonWorld = new PokemonWorld();
        pokemonWorldView = new PokemonWorldView();
        originalCoordinates = new Coordinates(3,4);
        pokemonWorldController = new PokemonWorldController(pokemonWorld,pokemonWorldView);
    }


    @Test
    /**
     * Test the sum of two coordinates
     */
    public void coordinatesSumTester(){

        Coordinates coordinates = new Coordinates(2,1);
        Coordinates coordinatesToSum = new Coordinates(3,2);

        Coordinates result = coordinates.sumCoordinates(coordinatesToSum);
        Coordinates expectedResult = new Coordinates(5,3);

        boolean testSucceed = false;

        if(result.getX()==expectedResult.getX() && result.getY()==expectedResult.getY()){
            testSucceed = true;
        }

        assertEquals(true,testSucceed);
    }

    @Test
    /**
     * Test the sum of a coordinate with move - N
     */
    public void coordinateSumMoveNTester(){

        boolean testN = false;

        Coordinates resultN = originalCoordinates.sumCoordinates(pokemonWorldController.getMovingCoordinates().get("N"));
        if(resultN.getX()==3 && resultN.getY()==3){
            testN = true;
        }

        assertEquals(testN, true);
    }

    @Test
    /**
     * Test the sum of a coordinate with move - S
     */
    public void coordinateSumMoveSTester(){

        boolean testS = false;

        Coordinates resultS = originalCoordinates.sumCoordinates(pokemonWorldController.getMovingCoordinates().get("S"));
        if(resultS.getX()==3 && resultS.getY()==5){
            testS = true;
        }

        assertEquals(testS, true);
    }

    @Test
    /**
     * Test the sum of a coordinate with move - E
     */
    public void coordinateSumMoveETester(){

        boolean testE = false;

        Coordinates resultE = originalCoordinates.sumCoordinates(pokemonWorldController.getMovingCoordinates().get("E"));
        if(resultE.getX()==4 && resultE.getY()==4){
            testE = true;
        }

        assertEquals(testE, true);
    }

    @Test
    /**
     * Test the sum of a coordinate with move - O
     */
    public void coordinateSumMoveOTester(){

        boolean testO = false;

        Coordinates resultO = originalCoordinates.sumCoordinates(pokemonWorldController.getMovingCoordinates().get("O"));
        if(resultO.getX()==2 && resultO.getY()==4){
            testO = true;
        }

        assertEquals(testO, true);
    }
}