class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    String shape;
    String cargo;

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    // Assign cargo with runtime safety check
    public void assignCargo(String cargo) {
        try {
            if ("Rectangular".equalsIgnoreCase(shape) && "Petroleum".equalsIgnoreCase(cargo)) {
                throw new CargoSafetyException(
                        "Unsafe cargo assignment: Petroleum cannot be assigned to a Rectangular bogie."
                );
            }
            this.cargo = cargo;
            System.out.println("Cargo '" + cargo + "' assigned to " + shape + " bogie successfully.");
        } catch (CargoSafetyException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Cargo assignment validation completed for " + shape + " bogie.\n");
        }
    }

    @Override
    public String toString() {
        return shape + " bogie with cargo: " + (cargo != null ? cargo : "None");
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        GoodsBogie cylindricalBogie = new GoodsBogie("Cylindrical");
        GoodsBogie rectangularBogie = new GoodsBogie("Rectangular");

        // Safe assignment
        cylindricalBogie.assignCargo("Petroleum");

        // Unsafe assignment
        rectangularBogie.assignCargo("Petroleum");

        // Safe assignment after exception
        rectangularBogie.assignCargo("Coal");

        // Print final bogie states
        System.out.println("Final bogie states:");
        System.out.println(cylindricalBogie);
        System.out.println(rectangularBogie);
    }
}