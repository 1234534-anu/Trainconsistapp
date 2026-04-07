import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistApp {

    public static void main(String[] args) {
        // Example bogie IDs (can be empty to test exception)
        String[] bogieIDs = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        // String[] bogieIDs = {}; // Uncomment to test empty array exception

        // Sort array for binary search precondition
        Arrays.sort(bogieIDs);

        // Display sorted bogie IDs
        System.out.println("Sorted Bogie IDs in the train consist:");
        System.out.println(Arrays.toString(bogieIDs));

        // Input search key from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Bogie ID to search: ");
        String searchKey = scanner.nextLine();

        try {
            // Perform search with defensive validation
            boolean found = searchBogie(bogieIDs, searchKey);

            if (found) {
                System.out.println("Bogie ID " + searchKey + " exists in the train consist.");
            } else {
                System.out.println("Bogie ID " + searchKey + " was NOT found in the train consist.");
            }
        } catch (IllegalStateException e) {
            // Handle empty bogie array scenario
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Search operation completed.");
            scanner.close();
        }
    }

    // Method with defensive check and binary search
    public static boolean searchBogie(String[] bogieIDs, String searchKey) {
        // Fail-fast validation
        if (bogieIDs == null || bogieIDs.length == 0) {
            throw new IllegalStateException("Cannot search: No bogies exist in the train.");
        }

        // Binary Search
        int low = 0;
        int high = bogieIDs.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = searchKey.compareTo(bogieIDs[mid]);

            if (cmp == 0) {
                return true; // Found
            } else if (cmp < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false; // Not found
    }
}