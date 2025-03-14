import java.util.*;

class MapFactory {
    public static Map<String, Pokemon> getMap(String type) {
        return switch (type.toLowerCase()) {
            case "hashmap" -> new HashMap<>();
            case "treemap" -> new TreeMap<>();
            case "linkedhashmap" -> new LinkedHashMap<>();
            default -> throw new IllegalArgumentException("Tipo de mapa no soportado");
        };
    }
}