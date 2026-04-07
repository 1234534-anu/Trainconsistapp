import java.util.ArrayList;
import java.util.List;

class GoodsBogie {
    String type;   // e.g., Cylindrical, Rectangular
    String cargo;  // e.g., Petroleum, Coal, Grain

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return type + " bogie carrying " + cargo;
    }
}

public class TrainConsistApp {

    public static void main(String[] args) {

        // Prepare a list of goods bogies
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Rectangular", "Coal"));
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Grain"));

        // Safety compliance check: Cylindrical bogies must carry Petroleum
        boolean isSafe = bogies.stream()
                .allMatch(b -> !b.type.equalsIgnoreCase("Cylindrical") || b.cargo.equalsIgnoreCase("Petroleum"));

        // Display results
        System.out.println("Train Goods Bogies:");
        bogies.forEach(System.out::println);

        if (isSafe) {
            System.out.println("✅ Train is SAFETY COMPLIANT.");
        } else {
            System.out.println("❌ Train is NOT SAFE! Cylindrical bogie cargo violation detected.");
        }
    }
}