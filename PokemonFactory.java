public interface PokemonFactory<T extends Pokemon> {
    T createPokemon(String[] data);
}