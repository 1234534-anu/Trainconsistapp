import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistApp {
    public static void main(String[] args) {
        // Unsorted array of bogie IDs
        String[] bogieIDs = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        // Sort array first to satisfy binary search precondition
        Arrays.sort(bogieIDs);

        // Display sorted bogie IDs
        System.out.println("Sorted Bogie IDs in the train consist:");
        System.out.println(Arrays.toString(bogieIDs));

        // Input search key from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Bogie ID to search: ");
        String searchKey = scanner.nextLine();

        // Binary Search
        boolean found = binarySearch(bogieIDs, searchKey);

        // Display result
        if (found) {
            System.out.println("Bogie ID " + searchKey + " exists in the train consist.");
        } else {
            System.out.println("Bogie ID " + searchKey + " was NOT found in the train consist.");
        }

        scanner.close();
    }

    // Binary Search Method
    public static boolean binarySearch(String[] array, String key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(array[mid]);

            if (cmp == 0) {
                return true; // Key found
            } else if (cmp < 0) {
                high = mid - 1; // Search left half
            } else {
                low = mid + 1;  // Search right half
            }
        }

        return false; // Key not found
    }
}