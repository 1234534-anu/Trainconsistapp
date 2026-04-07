class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class PassengerBogie {
    String type;
    int capacity;

    // Constructor with fail-fast validation
    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return type + " (" + capacity + " seats)";
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {
        try {
            PassengerBogie sleeper = new PassengerBogie("Sleeper", 72);
            PassengerBogie acChair = new PassengerBogie("AC Chair", 0); // Invalid
            System.out.println(sleeper);
            System.out.println(acChair);
        } catch (InvalidCapacityException e) {
            System.err.println("Error creating bogie: " + e.getMessage());
        }

        // Multiple valid bogies
        try {
            PassengerBogie firstClass = new PassengerBogie("First Class", 80);
            PassengerBogie deluxe = new PassengerBogie("Deluxe", 60);
            System.out.println("Valid bogies created successfully:");
            System.out.println(firstClass);
            System.out.println(deluxe);
        } catch (InvalidCapacityException e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}