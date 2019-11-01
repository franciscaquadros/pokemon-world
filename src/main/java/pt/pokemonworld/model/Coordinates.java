package pt.pokemonworld.model;

/**
 * A class to represent each coordinate object
 * Each pt.pokemonworld.model.Coordinates will have an id that corresponds
 * to a String resulting of the concatenation of x and y
 */
public class Coordinates {

    private int x;
    private int y;

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Method that sums the pt.pokemonworld.model.Coordinates object to another pt.pokemonworld.model.Coordinates,
     * resulting in a new pt.pokemonworld.model.Coordinates
     * @param coordinates
     * @return
     */
    public Coordinates sumCoordinates(Coordinates coordinates){

        return new Coordinates(this.x + coordinates.getX(), this.y + coordinates.getY());
    }

    /**
     * Method that returns the id of the pt.pokemonworld.model.Coordinates object, which
     * will be unique
     * @return
     */
    public String getId(){
        return Integer.toString(x) + Integer.toString(y);
    }
}
