public class TrainConsistApp {
    public static void main(String[] args) {
        // Example passenger bogie capacities
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Original capacities:");
        printArray(capacities);

        // Bubble Sort Algorithm
        for (int i = 0; i < capacities.length - 1; i++) {
            for (int j = 0; j < capacities.length - 1 - i; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    // Swap adjacent elements
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        System.out.println("\nSorted capacities (ascending order):");
        printArray(capacities);
    }

    private static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}