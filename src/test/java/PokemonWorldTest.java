import org.junit.Before;
import org.junit.Test;
import pt.pokemonworld.model.PokemonWorld;

import static org.junit.Assert.assertEquals;

/**
 * In this class the method initDefault is going to be tested
 * to confirm that it is working properly
 */
public class PokemonWorldTest {

    private PokemonWorld pokemonWorld;

    @Before
    public void setup(){
        pokemonWorld = new PokemonWorld();
    }

    @Test
    public void initDefaultTester(){

        pokemonWorld.initDefault();

        boolean testSucceed = false;

        if(pokemonWorld.getPokemonsCatched()==1 && pokemonWorld.getGrid().isEmpty() && pokemonWorld.getInitialPoint().getX()==0 && pokemonWorld.getInitialPoint().getY()==0){
            testSucceed = true;
        }

        assertEquals(testSucceed, true);

    }
}
