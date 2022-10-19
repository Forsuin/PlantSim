public class Wheat extends Plant{
    Wheat(String name){
        super(name, FertilizerType.JACKS, FertilizerType.DYNAGROW);
    }

    @Override
    void fertilize(FertilizerType fertilizer) {
        if(fertilizer == this.getPrimary()){
            if(this.getNeed() >= 50){
                this.changeNeed(-6);
            }
            else{
                this.changeNeed(-3);
            }
        }
        else if(fertilizer == this.getSecondary()){
            this.changeNeed(-3);
        }
        updateMusic();
    }

    @Override
    public String toString() {
        return String.format("%s the Wheat is listening to %s\n", this.getName(), this.getMusic().getName());
    }
}
