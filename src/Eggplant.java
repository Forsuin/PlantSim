public class Eggplant extends Plant{
    Eggplant(String name){
        super(name, FertilizerType.MANURE, FertilizerType.EGGSHELLS);
    }

    @Override
    void fertilize(FertilizerType fertilizer) {
        if(fertilizer == this.getPrimary()){
            this.changeNeed(-7);
        }
        else if(fertilizer == this.getSecondary()){
            this.changeNeed(-4);
        }

        updateMusic();
    }

    @Override
    public String toString() {
        return String.format("%s the Eggplant is listening to %s\n", this.getName(), this.getMusic().getName());
    }
}
