import java.util.*;

public class MapFactory {
    public static <T extends Pokemon> Map<String, T> getMap(String type) {
        return switch (type.toLowerCase()) {
            case "hashmap" -> new HashMap<>();
            case "treemap" -> new TreeMap<>();
            case "linkedhashmap" -> new LinkedHashMap<>();
            default -> throw new IllegalArgumentException("Tipo de mapa no soportado");
        };
    }
}