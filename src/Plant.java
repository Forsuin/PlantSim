import java.util.Random;

abstract public class Plant {
    private String name;
    private FertilizerType primary;
    private FertilizerType secondary;
    private MusicType music;
    private int need;

    Plant(String name, FertilizerType primary, FertilizerType secondary){
        this.name = name;
        this.primary = primary;
        this.secondary = secondary;

        Random rand = new Random();
        this.need = rand.nextInt(50, 100);

        updateMusic();
    }

    abstract void fertilize(FertilizerType fertilizer);


    public void updateMusic(){
        if(0 <= need && need < 20){
            music = MusicType.POP;
        }
        else if(20 <= need && need < 40){
            music = MusicType.HIPHOP;
        }
        else if(40 <= need && need < 60){
            music = MusicType.ALTERNATIVE;
        }
        else if(60 <= need && need < 80){
            music = MusicType.METAL;
        }
        else {
            music = MusicType.Classical;
        }
    }


    public String getName(){
        return this.name;
    }

    public FertilizerType getPrimary(){
        return this.primary;
    }

    public FertilizerType getSecondary(){
        return this.secondary;
    }

    public MusicType getMusic(){
        return this.music;
    }

    public int getNeed(){
        return this.need;
    }

    public void changeNeed(int amt){
        this.need += amt;

        if(this.need < 0){
            this.need = 0;
        }
        else if(this.need > 99){
            this.need = 99;
        }
    }
}
