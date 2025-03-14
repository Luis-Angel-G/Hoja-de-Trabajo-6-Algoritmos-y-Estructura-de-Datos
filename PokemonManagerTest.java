import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PokemonManagerTest {
    private PokemonManager<Pokemon> manager;

    @BeforeEach
    void setUp() throws IOException {
        manager = new PokemonManager<>("hashmap");
        manager.loadPokemons("pokemon_data_pokeapi.csv", Pokemon::new);
    }

    @Test
    void testAddPokemonToCollection() {
        manager.addPokemonToCollection("Bulbasaur");
        assertEquals(1, manager.getUserCollection().size());
        assertTrue(manager.getUserCollection().contains(manager.getPokemonMap().get("Bulbasaur")));
    }

    @Test
    void testShowPokemon() {
        manager.showPokemon("Bulbasaur");
        assertEquals("Bulbasaur", manager.getPokemonMap().get("Bulbasaur").name);
    }

    @Test
    void testShowUserPokemonsByType() {
        manager.addPokemonToCollection("Bulbasaur");
        manager.addPokemonToCollection("Charmander");
        manager.showUserPokemonsByType();
        assertEquals("Bulbasaur", manager.getUserCollection().get(0).name);
        assertEquals("Charmander", manager.getUserCollection().get(1).name);
    }

    @Test
    void testShowPokemonsByAbility() {
        manager.showPokemonsByAbility("Overgrow");
        assertTrue(manager.getPokemonMap().values().stream()
                .anyMatch(p -> p.getAbilities().contains("Overgrow")));
    }
}