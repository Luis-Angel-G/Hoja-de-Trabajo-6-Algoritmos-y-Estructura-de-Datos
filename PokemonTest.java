import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {

    @Test
    void testPokemonCreation() {
        String[] data = {"Bulbasaur", "1", "Grass", "Poison", "Seed Pokémon", "0.7", "6.9", "Overgrow, Chlorophyll", "1", "No"};
        Pokemon bulbasaur = new Pokemon(data);

        assertEquals("Bulbasaur", bulbasaur.name);
        assertEquals("Grass", bulbasaur.type1);
        assertEquals("Poison", bulbasaur.type2);
        assertEquals("Seed Pokémon", bulbasaur.classification);
        assertEquals(0.7, bulbasaur.height);
        assertEquals(6.9, bulbasaur.weight);
        assertEquals("Overgrow, Chlorophyll", bulbasaur.abilities);
        assertEquals(1, bulbasaur.generation);
        assertFalse(bulbasaur.legendary);
    }

    @Test
    void testPokemonToString() {
        String[] data = {"Bulbasaur", "1", "Grass", "Poison", "Seed Pokémon", "0.7", "6.9", "Overgrow, Chlorophyll", "1", "No"};
        Pokemon bulbasaur = new Pokemon(data);

        String expected = "Bulbasaur - Tipo1: Grass - Tipo2: Poison - Clasificación: Seed Pokémon - Altura: 0.7m - Peso: 6.9kg - Habilidades: Overgrow, Chlorophyll - Generación: 1 - Legendario: No";
        assertEquals(expected, bulbasaur.toString());
    }
}
