import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TrainConsistApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Train Consist Validation ===");

        // Input Train ID
        System.out.print("Enter Train ID (format TRN-1234): ");
        String trainID = scanner.nextLine();

        // Input Cargo Code
        System.out.print("Enter Cargo Code (format PET-AB): ");
        String cargoCode = scanner.nextLine();

        // Define regex patterns
        String trainPattern = "TRN-\\d{4}";
        String cargoPattern = "PET-[A-Z]{2}";

        // Compile patterns
        Pattern tPattern = Pattern.compile(trainPattern);
        Pattern cPattern = Pattern.compile(cargoPattern);

        // Create matcher objects
        Matcher tMatcher = tPattern.matcher(trainID);
        Matcher cMatcher = cPattern.matcher(cargoCode);

        // Validate Train ID
        if (tMatcher.matches()) {
            System.out.println("Train ID is VALID: " + trainID);
        } else {
            System.out.println("Train ID is INVALID: " + trainID);
        }

        // Validate Cargo Code
        if (cMatcher.matches()) {
            System.out.println("Cargo Code is VALID: " + cargoCode);
        } else {
            System.out.println("Cargo Code is INVALID: " + cargoCode);
        }

        scanner.close();
    }
}