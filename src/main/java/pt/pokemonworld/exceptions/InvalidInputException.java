package pt.pokemonworld.exceptions;

public class InvalidInputException extends Exception {

    public InvalidInputException(){
        super("Invalid Input! Moves must be N, S, E or O (north, south, east and west, respectively)");
    }
}
