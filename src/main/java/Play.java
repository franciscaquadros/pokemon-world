import pt.pokemonworld.controller.PokemonWorldController;
import pt.pokemonworld.exceptions.InvalidInputException;
import pt.pokemonworld.model.PokemonWorld;
import pt.pokemonworld.view.PokemonWorldView;

import java.util.Scanner;

/**
 * The Play class receives a line containing Ash's moves
 * on stdin and displays the number of pokemons he catched
 * to the standard output
 * If something goes wrong, an error is printed to the standard
 * output
 */
public class Play {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String moves = scanner.nextLine();
        scanner.close();

        /*instantiate the model represented by the class pt.pokemonworld.model.PokemonWorld*/
        PokemonWorld pokemonWorld = new PokemonWorld();
        /*make sure the pokemonWorld attributes are set to its initial state before the game starts*/
        pokemonWorld.initDefault();

        /*instantiate both the controller and the view which will be used to perform the result
        * and to display it to the standard output*/
        PokemonWorldView pokemonWorldView = new PokemonWorldView();
        PokemonWorldController pokemonWorldController = new PokemonWorldController(pokemonWorld, pokemonWorldView);

        try{
            /*calcultate the result to be displayed*/
            pokemonWorldController.calculatePokemonsCatched(moves);
            /*show the result in standard output*/
            pokemonWorldController.showView();

        }catch(InvalidInputException ex){
            /*show invalid input error message in standard output*/
            pokemonWorldController.showViewError(ex.getMessage());

        }catch(Exception ex){
            /*show generic error message in standard output*/
            String errorMessage = "An error occured while Ash was catching pokemons! Please try again.";
            pokemonWorldController.showViewError(errorMessage);
        }

    }
    
}
