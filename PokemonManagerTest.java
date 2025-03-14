import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase PokemonManager.
 * Proporciona métodos para verificar las operaciones de gestión de Pokémon.
 * 
 * @Project : Hoja de Trabajo 6 - Algoritmos y Estructura de Datos
 * @Author : Luis Angel Girón Arévalo
 * Creación : 13/03/2025
 * Última modificación : 13/03/2025
 * @File Name: PokemonManagerTest.java
 */
class PokemonManagerTest {
    private PokemonManager<Pokemon> manager;

    /**
     * Configuración inicial antes de cada prueba.
     * @throws IOException Si ocurre un error al cargar los datos de los Pokémon.
     */
    @BeforeEach
    void setUp() throws IOException {
        manager = new PokemonManager<>("hashmap");
        manager.loadPokemons("pokemon_data_pokeapi.csv", Pokemon::new);
    }

    /**
     * Prueba la adición de un Pokémon a la colección del usuario.
     */
    @Test
    void testAddPokemonToCollection() {
        manager.addPokemonToCollection("Bulbasaur");
        assertEquals(1, manager.getUserCollection().size());
        assertTrue(manager.getUserCollection().contains(manager.getPokemonMap().get("Bulbasaur")));
    }

    /**
     * Prueba la visualización de los datos de un Pokémon.
     */
    @Test
    void testShowPokemon() {
        manager.showPokemon("Bulbasaur");
        assertEquals("Bulbasaur", manager.getPokemonMap().get("Bulbasaur").name);
    }

    /**
     * Prueba la visualización de los Pokémon de la colección del usuario ordenados por tipo1.
     */
    @Test
    void testShowUserPokemonsByType() {
        manager.addPokemonToCollection("Bulbasaur");
        manager.addPokemonToCollection("Charmander");
        manager.showUserPokemonsByType();
        assertEquals("Bulbasaur", manager.getUserCollection().get(0).name);
        assertEquals("Charmander", manager.getUserCollection().get(1).name);
    }

    /**
     * Prueba la visualización de los Pokémon que tienen una habilidad específica.
     */
    @Test
    void testShowPokemonsByAbility() {
        manager.showPokemonsByAbility("Overgrow");
        assertTrue(manager.getPokemonMap().values().stream()
                .anyMatch(p -> p.getAbilities().contains("Overgrow")));
    }
}