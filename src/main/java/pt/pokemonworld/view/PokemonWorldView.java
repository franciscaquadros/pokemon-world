package pt.pokemonworld.view;

/**
 * This class represents the View
 * It is used to print the result or an error message in case
 * an error occurs
 */
public class PokemonWorldView {

    public void printResult(int pokemonsCatched){

        System.out.print(pokemonsCatched);
    }

    public void printError(String errorMessage){

        System.out.print(errorMessage);
    }
}
