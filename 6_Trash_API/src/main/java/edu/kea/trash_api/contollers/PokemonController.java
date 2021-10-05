package edu.kea.trash_api.contollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PokemonController {

    @GetMapping("/pokemon/go")
    public boolean pokemonGo(){
        return true;
    }

    @GetMapping("/pokemon")
    public List getAllPokemon(){
        List<String> pokemonList = Arrays.asList("Charmander", "Mew");

        return pokemonList;
    }

}
