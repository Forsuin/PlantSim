import java.util.HashMap;
import java.util.Random;

public class Inventory {
    HashMap<FertilizerType, Integer> currentInventory = new HashMap<>();
    HashMap<FertilizerType, Integer> amtUsed = new HashMap<>();

    Inventory() {
        currentInventory.put(FertilizerType.GRASS, 0);
        currentInventory.put(FertilizerType.JACKS, 0);
        currentInventory.put(FertilizerType.MANURE, 0);
        currentInventory.put(FertilizerType.EGGSHELLS, 0);
        currentInventory.put(FertilizerType.DYNAGROW, 0);
        currentInventory.put(FertilizerType.HAPPYFROG, 0);

        amtUsed.put(FertilizerType.GRASS, 0);
        amtUsed.put(FertilizerType.JACKS, 0);
        amtUsed.put(FertilizerType.MANURE, 0);
        amtUsed.put(FertilizerType.EGGSHELLS, 0);
        amtUsed.put(FertilizerType.DYNAGROW, 0);
        amtUsed.put(FertilizerType.HAPPYFROG, 0);
    }

    public void decrementFertilizer(FertilizerType fertilizerType){
        currentInventory.put(fertilizerType, currentInventory.get(fertilizerType) - 1);
        amtUsed.put(fertilizerType, amtUsed.get(fertilizerType) + 1);
    }

    public String getInventory(){
        StringBuilder output = new StringBuilder();

        for(var entry : currentInventory.entrySet()){
            output.append(String.format("%7s %2d ", entry.getKey().getName(), entry.getValue()));
        }

        return output.toString();
    }

    public String getAmtUsed(){
        StringBuilder output = new StringBuilder();

        for(var entry : amtUsed.entrySet()){
            output.append(String.format("%7s %2d ", entry.getKey().getName(), entry.getValue()));
        }

        return output.toString();
    }

    public boolean has(FertilizerType fertilizerType){
        return currentInventory.get(fertilizerType) > 0;
    }

    public String takeDelivery(){
        StringBuilder output = new StringBuilder();

        Random random = new Random();

        for(var entry : currentInventory.entrySet()){
            int amt = random.nextInt(0, 4);

            currentInventory.put(entry.getKey(), entry.getValue() + amt);
            output.append(String.format("%7s %2d ", entry.getKey().getName(), entry.getValue()));
        }

        return output.toString();
    }
}
