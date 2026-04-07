import java.util.ArrayList;
import java.util.List;

// Bogie class (same as previous UCs)
class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create bogie list
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));

        // Calculate total seating capacity using Stream reduce()
        int totalCapacity = bogies.stream()
                .map(b -> b.capacity)        // extract capacity
                .reduce(0, Integer::sum);   // aggregate sum

        // Display result
        System.out.println("Total Seating Capacity of Train: " + totalCapacity);

        // Verify original list remains unchanged
        System.out.println("\nOriginal Bogie List:");
        bogies.forEach(System.out::println);
    }
}