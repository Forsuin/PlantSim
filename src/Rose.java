public class Rose extends Plant{
    Rose(String name){
        super(name, FertilizerType.DYNAGROW, FertilizerType.JACKS);
    }

    @Override
    void fertilize(FertilizerType fertilizer) {
        if(fertilizer == this.getPrimary()){
            this.changeNeed(-8);
        }
        else if(fertilizer == this.getSecondary()){
            this.changeNeed(-1);
        }

        updateMusic();
    }

    @Override
    public String toString() {
        return String.format("%s the Rose is listening to %s\n", this.getName(), this.getMusic().getName());
    }
}
