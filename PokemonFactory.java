/**
 * La interfaz PokemonFactory define el método necesario para crear instancias de Pokémon.
 * Utiliza el patrón de diseño Factory para la creación de objetos Pokémon.
 * @Project : Hoja de Trabajo 6 - Algoritmos y Estructura de Datos
 * @Author : Luis Angel Girón Arévalo
 * Creación : 13/03/2025
 * Última modificación : 13/03/2025
 * @File Name: PokemonFactory.java
 */
public interface PokemonFactory<T extends Pokemon> {

    /**
     * Crea una instancia de Pokémon a partir de un array de datos.
     * @param data Un array de cadenas que contiene los datos del Pokémon.
     * @return Una instancia de Pokémon creada a partir de los datos proporcionados.
     */
    T createPokemon(String[] data);
}