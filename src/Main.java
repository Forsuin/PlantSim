import java.util.ArrayList;

public class Main {
    static ArrayList<Plant> arr;

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Corn John = new Corn("John");
        Corn Jeff = new Corn("Jeff");

        Wheat Brian = new Wheat("Brian");
        Wheat Kevin = new Wheat("Kevin");

        Eggplant Kyle = new Eggplant("Kyle");
        Eggplant Brad = new Eggplant("Brad");

        Daisy daisy = new Daisy("Daisy");
        Daisy Lance = new Daisy("Lance");

        Rose rose = new Rose("Rose");
        Rose Jack = new Rose("Jane");

        arr = new ArrayList<>();

        arr.add(John);
        arr.add(Jeff);
        arr.add(Brian);
        arr.add(Kevin);
        arr.add(Kyle);
        arr.add(Brad);
        arr.add(daisy);
        arr.add(Lance);
        arr.add(rose);
        arr.add(Jack);


        StringBuilder output;
        int day = 0;

        while(!allPop()){
            arr.sort(new PlantComparator().reversed());
            output = new StringBuilder();
            day++;

            output.append(String.format("Day: %d\n", day));
            output.append(String.format("Delivery: %s\n", inventory.takeDelivery()));
            output.append(String.format("Current Stock: %s\n", inventory.getInventory()));
            output.append("_________________________________________________________________________\n");

            for(Plant plant : arr){
                FertilizerType primary = plant.getPrimary();
                FertilizerType secondary = plant.getSecondary();
                boolean wasFertilized = false;
                boolean wasPrimary = true;

                if(plant.getMusic() != MusicType.POP){
                    if(inventory.has(primary)){
                        plant.fertilize(primary);
                        inventory.decrementFertilizer(primary);
                        wasFertilized = true;
                    }
                    else if(inventory.has(secondary)){
                        plant.fertilize(secondary);
                        inventory.decrementFertilizer(secondary);
                        wasFertilized = true;
                        wasPrimary = false;
                    }
                }

                if(wasFertilized){
                    if(wasPrimary){
                        output.append(String.format("%s was fertilized with %s\n", plant.getName(), plant.getPrimary().getName()));
                    }
                    else{
                        output.append(String.format("%s was fertilized with %s\n", plant.getName(), plant.getSecondary().getName()));
                    }
                }
                else {
                    output.append(String.format("%s was not fertilized!\n", plant.getName()));
                }

                output.append(plant.toString());
            }

            System.out.println(output + "\n");
        }

        output = new StringBuilder();
        output.append(String.format("Total Days: %d\n", day));
        output.append(String.format("Current Stock: %s\n", inventory.getInventory()));
        output.append(String.format("Doses used: %s\n", inventory.getAmtUsed()));
        output.append("_________________________________________________________________________\n");

        for(Plant plant : arr){
            output.append(plant.toString());
        }

        System.out.print(output.toString());
    }

    private static boolean allPop(){
        for(Plant plant : arr){
            if(plant.getMusic() != MusicType.POP){
                return false;
            }
        }

        return true;
    }
}