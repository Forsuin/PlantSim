import java.util.Comparator;

public class PlantComparator implements Comparator<Plant> {
    @Override
    public int compare(Plant left, Plant right) {
        return Integer.compare(left.getNeed(), right.getNeed());
    }
}
