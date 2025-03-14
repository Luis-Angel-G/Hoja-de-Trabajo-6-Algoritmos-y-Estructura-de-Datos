import java.io.*;
import java.util.*;

public class PokemonManager<T extends Pokemon> {
    private final Map<String, T> pokemonMap;
    private final List<T> userCollection;

    public PokemonManager(String mapType) {
        this.pokemonMap = MapFactory.getMap(mapType);
        this.userCollection = new ArrayList<>();
    }

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

    public void addPokemonToCollection(String name) {
        T p = pokemonMap.get(name);
        if (p != null && !userCollection.contains(p)) {
            userCollection.add(p);
            System.out.println(name + " se ha agregado a tu colección.");
        }
        else if(userCollection.contains(p)) {
            System.out.println(name + " ya está en tu colección, no se puede agregar.");
        } else {
            System.out.println("Pokemon no encontrado.");
        }
    }

    public void showPokemon(String name) {
        T p = pokemonMap.get(name);
        System.out.println(p != null ? p : "Pokemon no encontrado.");
    }

    public void showUserCollection() {
        userCollection.forEach(System.out::println);
    }

    public void showUserPokemonsByType() {
        List<T> sortedList = new ArrayList<>(userCollection);
        sortedList.sort(Comparator.comparing(p -> p.type1));
        for (T p : sortedList) {
            System.out.println(p.name + " - " + p.type1);
        }
    }

    public void showPokemonsByType() {
        List<T> sortedList = new ArrayList<>(pokemonMap.values());
        sortedList.sort(Comparator.comparing(p -> p.type1));
        for (T p : sortedList) {
            System.out.println(p.name + " - " + p.type1);
        }
    }
    
    public void showPokemonsByAbility(String ability) {
        System.out.println("Pokemons con la habilidad " + ability + ":");
        pokemonMap.values().stream()
                .filter(p -> Arrays.asList(p.getAbilities().split(", ")).contains(ability))
                .forEach(p -> System.out.println(p.name + " - " + p.abilities));
    }
    
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