public enum FertilizerType {
    GRASS("Grass"),
    JACKS("Jack's"),
    MANURE("Manure"),
    EGGSHELLS("Eggshells"),
    DYNAGROW("Dyna-Grow"),
    HAPPYFROG("Happy Frog");

    private final String name;

    FertilizerType(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
