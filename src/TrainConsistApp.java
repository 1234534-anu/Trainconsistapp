import java.util.Scanner;

public class TrainConsistApp {
    public static void main(String[] args) {
        // Array of bogie IDs (unsorted)
        String[] bogieIDs = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Display all bogie IDs
        System.out.println("Bogie IDs in the train consist:");
        for (String id : bogieIDs) {
            System.out.print(id + " ");
        }
        System.out.println("\n");

        // Input search key from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Bogie ID to search: ");
        String searchKey = scanner.nextLine();

        // Linear search
        boolean found = false;
        for (String id : bogieIDs) {
            if (id.equals(searchKey)) {
                found = true;
                break; // Early termination on match
            }
        }

        // Display result
        if (found) {
            System.out.println("Bogie ID " + searchKey + " exists in the train consist.");
        } else {
            System.out.println("Bogie ID " + searchKey + " was NOT found in the train consist.");
        }

        scanner.close();
    }
}