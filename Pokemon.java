/**
 * Clase que representa un Pokémon con sus atributos y métodos relacionados.
 * Proporciona métodos para gestionar los datos de un Pokémon y generar su representación en cadena.
 * 
 * @Project : Hoja de Trabajo 6 - Algoritmos y Estructura de Datos
 * @Author : Luis Angel Girón Arévalo
 * Creación : 13/03/2025
 * Última modificación : 13/03/2025
 * @File Name: Pokemon.java
 */
public class Pokemon {
    String name, type1, type2, classification, abilities;
    double height, weight;
    int generation;
    boolean legendary;

    /**
     * Constructor de la clase Pokemon que inicializa los atributos con los valores proporcionados.
     * 
     * @param name El nombre del Pokémon.
     * @param type1 El tipo primario del Pokémon.
     * @param type2 El tipo secundario del Pokémon.
     * @param classification La clasificación del Pokémon.
     * @param height La altura del Pokémon en metros.
     * @param weight El peso del Pokémon en kilogramos.
     * @param abilities Las habilidades del Pokémon.
     * @param generation La generación del Pokémon.
     * @param legendary Indica si el Pokémon es legendario.
     */
    public Pokemon(String name, String type1, String type2, String classification, double height, double weight, String abilities, int generation, boolean legendary) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.classification = classification;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
        this.generation = generation;
        this.legendary = legendary;
    }

    /**
     * Constructor de la clase Pokemon que inicializa los atributos a partir de un array de datos.
     * 
     * @param data Un array de cadenas que contiene los datos del Pokémon.
     */
    public Pokemon(String[] data) {
        this.name = data[0].trim();
        this.type1 = data[2].trim();
        this.type2 = data[3].trim();
        this.classification = data[4].trim();
        this.height = Double.parseDouble(data[5].trim());
        this.weight = Double.parseDouble(data[6].trim());
        this.abilities = data[7].trim().replaceAll("\"", "");
        this.generation = Integer.parseInt(data[8].trim());
        this.legendary = data[9].trim().equalsIgnoreCase("Yes");
    }

    /**
     * Obtiene las habilidades del Pokémon.
     * 
     * @return Las habilidades del Pokémon.
     */
    public String getAbilities() {
        return abilities;
    }

    /**
     * Genera una representación en cadena del Pokémon con todos sus atributos.
     * 
     * @return Una cadena que representa al Pokémon.
     */
    @Override
    public String toString() {
        return name + " - Tipo1: " + type1 + " - Tipo2: " + type2 + " - Clasificación: " + classification + " - Altura: " + height + "m - Peso: " + weight + "kg - Habilidades: " + abilities + " - Generación: " + generation + " - Legendario: " + (legendary ? "Sí" : "No");
    }
}