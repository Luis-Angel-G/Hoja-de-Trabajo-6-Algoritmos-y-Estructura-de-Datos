class Pokemon {
    String name, type1, type2, classification, abilities;
    double height, weight;
    int generation;
    boolean legendary;

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

    @Override
    public String toString() {
        return name + " - Tipo1: " + type1 + " - Tipo2: " + type2 + " - Clasificación: " + classification + " - Altura: " + height + "m - Peso: " + weight + "kg - Habilidades: " + abilities + " - Generación: " + generation + " - Legendario: " + (legendary ? "Sí" : "No");
    }
}