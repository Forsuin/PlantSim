public enum MusicType {
    POP("Pop"),
    HIPHOP("Hip-Hop"),
    ALTERNATIVE("Alternative"),
    METAL("Metal"),
    Classical("Classical");

    private final String name;

    MusicType(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
