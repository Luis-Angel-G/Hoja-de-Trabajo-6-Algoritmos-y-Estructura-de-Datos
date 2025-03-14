import java.io.*;
import java.util.*;

/**
 * Clase que gestiona la colección de Pokémon y las operaciones relacionadas.
 * Utiliza un mapa para almacenar los Pokémon y una lista para la colección del usuario.
 * @param <T> El tipo de Pokémon que se gestionará.
 * @Project : Hoja de Trabajo 6 - Algoritmos y Estructura de Datos
 * @Author : Luis Angel Girón Arévalo
 * Creación : 13/03/2025
 * Última modificación : 13/03/2025
 * @File Name: PokemonManager.java
 */
public class PokemonManager<T extends Pokemon> {
    private final Map<String, T> pokemonMap;
    private final List<T> userCollection;

    /**
     * Constructor que inicializa el mapa de Pokémon y la colección del usuario.
     * @param mapType El tipo de estructura de mapa a utilizar (hashmap, treemap, linkedhashmap).
     */
    public PokemonManager(String mapType) {
        this.pokemonMap = MapFactory.getMap(mapType);
        this.userCollection = new ArrayList<>();
    }

    /**
     * Carga los datos de los Pokémon desde un archivo CSV.
     * @param filePath La ruta del archivo CSV.
     * @param factory La fábrica de Pokémon para crear instancias de Pokémon.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public void loadPokemons(String filePath, PokemonFactory<T> factory) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Saltar encabezado
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if (data.length < 10) continue;
                T pokemon = factory.createPokemon(data);
                pokemonMap.put(pokemon.name, pokemon);
            }
        }
    }

    /**
     * Agrega un Pokémon a la colección del usuario.
     * @param name El nombre del Pokémon a agregar.
     */
    public void addPokemonToCollection(String name) {
        T p = pokemonMap.get(name);
        if (p != null && !userCollection.contains(p)) {
            userCollection.add(p);
            System.out.println(name + " se ha agregado a tu colección.");
        } else if (userCollection.contains(p)) {
            System.out.println(name + " ya está en tu colección, no se puede agregar.");
        } else {
            System.out.println("Pokemon no encontrado.");
        }
    }

    /**
     * Muestra los datos de un Pokémon.
     * @param name El nombre del Pokémon a mostrar.
     */
    public void showPokemon(String name) {
        T p = pokemonMap.get(name);
        System.out.println(p != null ? p : "Pokemon no encontrado.");
    }

    /**
     * Muestra todos los Pokémon de la colección del usuario.
     */
    public void showUserCollection() {
        userCollection.forEach(System.out::println);
    }

    /**
     * Muestra los Pokémon de la colección del usuario ordenados por tipo1.
     */
    public void showUserPokemonsByType() {
        List<T> sortedList = new ArrayList<>(userCollection);
        sortedList.sort(Comparator.comparing(p -> p.type1));
        for (T p : sortedList) {
            System.out.println(p.name + " - " + p.type1);
        }
    }

    /**
     * Muestra todos los Pokémon leídos ordenados por tipo1.
     */
    public void showPokemonsByType() {
        List<T> sortedList = new ArrayList<>(pokemonMap.values());
        sortedList.sort(Comparator.comparing(p -> p.type1));
        for (T p : sortedList) {
            System.out.println(p.name + " - " + p.type1);
        }
    }

    /**
     * Muestra los Pokémon que tienen la habilidad indicada.
     * @param ability La habilidad a buscar.
     */
    public void showPokemonsByAbility(String ability) {
        System.out.println("Pokemons con la habilidad " + ability + ":");
        pokemonMap.values().stream()
                .filter(p -> Arrays.asList(p.getAbilities().split(", ")).contains(ability))
                .forEach(p -> System.out.println(p.name + " - " + p.abilities));
    }

    /**
     * Obtiene el mapa de Pokémon.
     * @return El mapa de Pokémon.
     */
    public Map<String, T> getPokemonMap() {
        return pokemonMap;
    }

    /**
     * Obtiene la colección de Pokémon del usuario.
     * @return La colección de Pokémon del usuario.
     */
    public List<T> getUserCollection() {
        return userCollection;
    }

    /**
     * Método principal que ejecuta el programa.
     * @param args Argumentos de línea de comandos (no utilizados).
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese el tipo de estructura a utilizar (hashmap, treemap, linkedhashmap):");
            String mapType = scanner.nextLine();

            PokemonManager<Pokemon> manager = new PokemonManager<>(mapType);
            manager.loadPokemons("pokemon_data_pokeapi.csv", Pokemon::new);

            int choice;
            do {
                System.out.println("\nMenú: \n1. Agregar Pokémon\n2. Mostrar Pokémon\n3. Mostrar todos los Pokémon de la colección\n4. Mostrar todos los Pokémon leídos por tipo\n5. Buscar por habilidad\n6. Mostrar Pokémon de la colección ordenados por tipo\n7. Salir");
                System.out.print("Opción: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.println("Ingrese el nombre del Pokémon: ");
                        String name = scanner.nextLine();
                        manager.addPokemonToCollection(name);
                    }
                    case 2 -> {
                        System.out.println("Ingrese el nombre del Pokémon: ");
                        String name = scanner.nextLine();
                        manager.showPokemon(name);
                    }
                    case 3 -> manager.showUserCollection();
                    case 4 -> manager.showPokemonsByType();
                    case 5 -> {
                        System.out.println("Ingrese la habilidad: ");
                        String ability = scanner.nextLine();
                        manager.showPokemonsByAbility(ability);
                    }
                    case 6 -> manager.showUserPokemonsByType();
                }
            } while (choice != 7);
        }
    }
}