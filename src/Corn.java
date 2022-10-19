public class Corn extends Plant{

    Corn(String name){
        super(name, FertilizerType.GRASS, FertilizerType.HAPPYFROG);
    }

    @Override
    void fertilize(FertilizerType fertilizer) {
        if(fertilizer == this.getPrimary()){
            this.changeNeed(-4);
        }
        else if(fertilizer == this.getSecondary()){
            this.changeNeed(-2);
        }
        updateMusic();
    }

    @Override
    public String toString() {
        return String.format("%s the Corn is listening to %s\n", this.getName(), this.getMusic().getName());
    }
}
