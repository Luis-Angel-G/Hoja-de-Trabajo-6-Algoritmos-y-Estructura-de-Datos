class Pokemon {
    String name, type1, ability;

    public Pokemon(String name, String type1, String ability) {
        this.name = name;
        this.type1 = type1;
        this.ability = ability;
    }

    @Override
    public String toString() {
        return name + " - Tipo: " + type1 + " - Habilidad: " + ability;
    }
}