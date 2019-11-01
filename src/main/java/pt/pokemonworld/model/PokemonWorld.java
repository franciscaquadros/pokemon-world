package pt.pokemonworld.model;

import java.util.HashSet;
import java.util.Set;

/**
 * The model representing the domain data for pokemon game
 * It holds the result - pokemonsCatched -, a set containing
 * the id of the coordinates where Ash has passed and the
 * coordinates of the initial point
 */
public class PokemonWorld {

    private int pokemonsCatched;
    private Coordinates initialPoint;
    private Set<String> grid = new HashSet<String>();

    /**
     * Provides the means to set or reset the model to
     * a default state
     */
    public void initDefault(){
        setPokemonsCatched(1);
        setGrid(new HashSet<String>());
        setInitialPoint(new Coordinates(0,0));
    }

    /**
     * Returns the number of pokemons catched at the
     * moment it is invoked
     */
    public int getPokemonsCatched() {
        return pokemonsCatched;
    }

    /**
     * Provides the means to set or update the number of
     * pokemons catched
     */
    public void setPokemonsCatched(int pokemonsCatched) {
        this.pokemonsCatched = pokemonsCatched;
    }

    /**
     * Returns the Set with the coordinates where Ash has
     * been to already
     */
    public Set<String> getGrid() {
        return grid;
    }

    /**
     * Provides the means to set or update the Set containing
     * the coordinates where Ash has passed already
     */
    public void setGrid(Set<String> grid) {
        this.grid = grid;
    }

    /**
     * Returns the coordinates of the initial point
     * @return pt.pokemonworld.model.Coordinates
     */
    public Coordinates getInitialPoint() {
        return initialPoint;
    }

    /**
     * Sets the coordinates of the initial point
     * @param initialPoint
     */
    public void setInitialPoint(Coordinates initialPoint) {
        this.initialPoint = initialPoint;
    }

}
