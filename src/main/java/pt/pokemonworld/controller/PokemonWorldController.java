package pt.pokemonworld.controller;

import pt.pokemonworld.exceptions.InvalidInputException;
import pt.pokemonworld.model.Coordinates;
import pt.pokemonworld.model.PokemonWorld;
import pt.pokemonworld.view.PokemonWorldView;

import java.util.*;

/**
 * This class represents the controller which handles all the actions
 * and works as an intermediary between model and view
 * It calculates the result and calls the view's method 'printResult'
 * to display it
 */
public class PokemonWorldController {

    private PokemonWorld pokemonWorld;
    private PokemonWorldView pokemonWorldView;
    private Map<String, Coordinates> movingCoordinates = new HashMap<String, Coordinates>(){
        {
            put("N", new Coordinates(0,-1));
            put("S", new Coordinates(0,1));
            put("E", new Coordinates(1,0));
            put("O", new Coordinates(-1, 0));
        }
    };


    public PokemonWorldController(PokemonWorld pokemonWorld, PokemonWorldView pokemonWorldView){
        this.pokemonWorld = pokemonWorld;
        this.pokemonWorldView = pokemonWorldView;
    }

    /**
     * Method that calls the view's method 'printResult' to show
     * the result of the game
     */
    public void showView(){
        pokemonWorldView.printResult(pokemonWorld.getPokemonsCatched());
    }

    /**
     * Method that calls the view's method 'printError' to show an
     * error message
     * @param errorMessage
     */
    public void showViewError(String errorMessage){ pokemonWorldView.printError(errorMessage);}

    /**
     * Method that calculates the number of pokemons Ash catched
     * based on the moves given as input
     * @param moves
     */
    public void calculatePokemonsCatched(String moves) throws InvalidInputException{

        if(moves!=null && !moves.isEmpty()){

            Coordinates currentPosition = pokemonWorld.getInitialPoint();
            /*We have to put the initial position coordinates id in the grid, because it is a position where Ash has
            * been to and thus there will be no more pokemons there in the future*/
            pokemonWorld.getGrid().add(currentPosition.getId());
            /*Get all the moves from the input and save them in an array*/
            String[] movesArray = moves.split("(?!^)");
            int size = movesArray.length;

            /*loop through the moves array*/
            for(int j = 0; j < size; j ++){
                if(!movesArray[j].equals("N") && !movesArray[j].equals("S") && !movesArray[j].equals("E") && !movesArray[j].equals("O")){
                    throw new InvalidInputException();
                }
                /*get the next position where Ash will be based on the move*/
                currentPosition = getNextCoordinates(currentPosition, movesArray[j]);

                /*check if Ash has already been in that position or if there is still a pokemon to catch and if so,
                * increment the number of pokemons catched and add the position to the grid */
                if(!pokemonWorld.getGrid().contains(currentPosition.getId())){
                    pokemonWorld.setPokemonsCatched(pokemonWorld.getPokemonsCatched()+1);
                    pokemonWorld.getGrid().add(currentPosition.getId());
                }
            }
        }
    }

    /**
     * Method that gives the next coordinates based on the current position
     * and the following move (which can be N,S,E or O)
     * @param currentPosition
     * @param move
     * @return
     */
    private Coordinates getNextCoordinates(Coordinates currentPosition, String move){

        currentPosition = currentPosition.sumCoordinates(movingCoordinates.get(move));

        return currentPosition;
    }

    public Map<String, Coordinates> getMovingCoordinates() {
        return movingCoordinates;
    }
}