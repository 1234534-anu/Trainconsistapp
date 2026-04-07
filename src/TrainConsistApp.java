import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class PassengerBogie {
    String name;
    int capacity;

    public PassengerBogie(String name, int capacity) {
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

        // Prepare a collection of bogies for testing
        List<PassengerBogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bogies.add(new PassengerBogie("Sleeper", 72));
            bogies.add(new PassengerBogie("AC Chair", 56));
            bogies.add(new PassengerBogie("First Class", 80));
        }

        // ----- Loop-Based Filtering -----
        long startLoop = System.nanoTime();
        List<PassengerBogie> highCapacityLoop = new ArrayList<>();
        for (PassengerBogie b : bogies) {
            if (b.capacity > 60) {
                highCapacityLoop.add(b);
            }
        }
        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // ----- Stream-Based Filtering -----
        long startStream = System.nanoTime();
        List<PassengerBogie> highCapacityStream = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // ----- Results -----
        System.out.println("Loop filtered bogies count: " + highCapacityLoop.size());
        System.out.println("Stream filtered bogies count: " + highCapacityStream.size());
        System.out.println("Loop execution time (ns): " + loopTime);
        System.out.println("Stream execution time (ns): " + streamTime);

        // Optional: display a few filtered bogies
        System.out.println("\nSample filtered bogies:");
        highCapacityLoop.stream().limit(5).forEach(System.out::println);
    }
}