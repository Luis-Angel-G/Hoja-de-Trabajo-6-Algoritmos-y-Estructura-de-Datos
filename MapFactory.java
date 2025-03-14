import java.util.*;

/**
 * La clase MapFactory proporciona un método para obtener diferentes implementaciones de Map.
 * Utiliza el patrón de diseño Factory para seleccionar la implementación de Map en tiempo de ejecución.
 * @Project : Hoja de Trabajo 6 - Algoritmos y Estructura de Datos 3
 * @Author : Luis Angel Girón Arévalo
 * Creación : 13/03/2025
 * Última modificación : 13/03/2025
 * @File Name: MapFactory.java
 */
public class MapFactory {

    /**
     * Obtiene una implementación de Map basada en el tipo especificado.
     * @param type El tipo de estructura de mapa a utilizar (hashmap, treemap, linkedhashmap).
     * @param <T> El tipo de los valores en el mapa, que debe extender de Pokemon.
     * @return Una implementación de Map correspondiente al tipo especificado.
     * @throws IllegalArgumentException Si el tipo de mapa no es soportado.
     */
    public static <T extends Pokemon> Map<String, T> getMap(String type) {
        return switch (type.toLowerCase()) {
            case "hashmap" -> new HashMap<>();
            case "treemap" -> new TreeMap<>();
            case "linkedhashmap" -> new LinkedHashMap<>();
            default -> throw new IllegalArgumentException("Tipo de mapa no soportado");
        };
    }
}