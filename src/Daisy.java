public class Daisy extends Plant{
    Daisy(String name){
        super(name, FertilizerType.EGGSHELLS, FertilizerType.MANURE);
    }

    @Override
    void fertilize(FertilizerType fertilizer) {
        if(fertilizer == this.getPrimary()){
            if(this.getNeed() >= 70){
                this.changeNeed(-7);
            }
            else {
                this.changeNeed(-3);
            }
        }
        else if(fertilizer == this.getSecondary()){
            this.changeNeed(-2);
        }

        updateMusic();
    }

    @Override
    public String toString() {
        return String.format("%s the Daisy is listening to %s\n", this.getName(), this.getMusic().getName());
    }
}
