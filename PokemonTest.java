import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase Pokemon.
 * Proporciona métodos para verificar la correcta creación y representación en cadena de objetos Pokemon.
 * 
 * @Project : Hoja de Trabajo 6 - Algoritmos y Estructura de Datos
 * @Author : Luis Angel Girón Arévalo
 * Creación : 13/03/2025
 * Última modificación : 13/03/2025
 * @File Name: PokemonTest.java
 */
class PokemonTest {

    /**
     * Prueba la correcta creación de un objeto Pokemon a partir de un array de datos.
     */
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

    /**
     * Prueba la representación en cadena de un objeto Pokemon.
     */
    @Test
    void testPokemonToString() {
        String[] data = {"Bulbasaur", "1", "Grass", "Poison", "Seed Pokémon", "0.7", "6.9", "Overgrow, Chlorophyll", "1", "No"};
        Pokemon bulbasaur = new Pokemon(data);

        String expected = "Bulbasaur - Tipo1: Grass - Tipo2: Poison - Clasificación: Seed Pokémon - Altura: 0.7m - Peso: 6.9kg - Habilidades: Overgrow, Chlorophyll - Generación: 1 - Legendario: No";
        assertEquals(expected, bulbasaur.toString());
    }
}
