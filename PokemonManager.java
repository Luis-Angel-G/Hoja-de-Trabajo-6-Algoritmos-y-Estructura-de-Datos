import java.io.*;
import java.util.*;

public class PokemonManager {
    private final Map<String, Pokemon> pokemonMap;
    private final List<Pokemon> userCollection;

    public PokemonManager(String mapType) {
        this.pokemonMap = MapFactory.getMap(mapType);
        this.userCollection = new ArrayList<>();
    }

    public void loadPokemons(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Saltar encabezado
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 3) continue;
                String name = data[0].trim();
                String type1 = data[1].trim();
                String ability = data.length > 2 ? data[2] : "Unknown";
                pokemonMap.put(name, new Pokemon(name, type1, ability));
            }
        }
    }

    public void addPokemonToCollection(String name) {
        Pokemon p = pokemonMap.get(name);
        if (p != null && !userCollection.contains(p)) {
            userCollection.add(p);
            System.out.println(name + " added to your collection.");
        } else {
            System.out.println(name + " is either already in your collection or does not exist.");
        }
    }

    public void showPokemon(String name) {
        Pokemon p = pokemonMap.get(name);
        System.out.println(p != null ? p : "Pokemon not found.");
    }

    public void showUserCollection() {
        userCollection.forEach(System.out::println);
    }

    public void showPokemonsByType() {
        List<Pokemon> sortedList = new ArrayList<>(pokemonMap.values());
        sortedList.sort(Comparator.comparing(p -> p.type1));
        for (Pokemon p : sortedList) {
            System.out.println(p.name + " - " + p.type1);
        }
    }
    
    public void showPokemonsByAbility(String ability) {
        System.out.println("Pokemons with ability " + ability + ":");
        pokemonMap.values().stream()
                .filter(p -> p.ability.equalsIgnoreCase(ability))
                .forEach(System.out::println);
    }
    
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese el tipo de estructura a utilizar (hashmap, treemap, linkedhashmap):");
            String mapType = scanner.nextLine();
            
            PokemonManager manager = new PokemonManager(mapType);
            manager.loadPokemons("pokemon_data_pokeapi.csv");
            
            int choice;
            do {
                System.out.println("\nMenú: \n1. Agregar Pokémon\n2. Mostrar Pokémon\n3. Mostrar todos los Pokémon de la colección\n4. Mostrar todos los Pokémon leídos por tipo\n5. Buscar por habilidad\n6. Salir");
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
                }
            } while (choice != 6);
        }
    }
}