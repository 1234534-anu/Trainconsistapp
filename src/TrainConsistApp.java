import java.util.Arrays;

public class TrainConsistApp {
    public static void main(String[] args) {
        // Array of bogie type names
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Original bogie names:");
        System.out.println(Arrays.toString(bogieNames));

        // Sort using built-in Arrays.sort()
        Arrays.sort(bogieNames);

        System.out.println("\nSorted bogie names (alphabetical order):");
        System.out.println(Arrays.toString(bogieNames));
    }
}