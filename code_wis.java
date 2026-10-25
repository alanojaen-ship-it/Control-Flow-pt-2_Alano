import java.util.Scanner;

public class code_wis {
    static Scanner sc = new Scanner(System.in);

    static int[][] warehouse = {
        {10, 5, -1, 8},
        {3, 15, 2, 7},
        {12, -1, 4, 6}
    };

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== WAREHOUSE INVENTORY ===");
            System.out.println("1. View Inventory");
            System.out.println("2. Total Inventory");
            System.out.println("3. Find Critical Low Shelf");
            System.out.println("4. Restock Shelf");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewInventory();
                    break;
                case 2:
                    totalInventory();
                    break;
                case 3:
                    findLowShelf();
                    break;
                case 4:
                    restock();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }

    static void viewInventory() {
        for (int i = 0; i < warehouse.length; i++) {
            for (int j = 0; j < warehouse[i].length; j++) {
                System.out.print(warehouse[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static void totalInventory() {
        int total = 0;

        for (int[] row : warehouse) {
            for (int count : row) {
                if (count == -1) {
                    continue;
                }
                total += count;
            }
        }

        System.out.println("Total Inventory: " + total);
    }

    static void findLowShelf() {
        boolean found = false;

        for (int i = 0; i < warehouse.length; i++) {
            for (int j = 0; j < warehouse[i].length; j++) {
                if (warehouse[i][j] == -1) {
                    continue;
                }

                if (warehouse[i][j] < 5) {
                    System.out.println("Critical Low Shelf at Row "
                            + (i + 1) + ", Column " + (j + 1));
                    found = true;
                    break;
                }
            }

            if (found) {
                break;
            }
        }

        if (!found) {
            System.out.println("No critical low shelf found.");
        }
    }

    static void restock() {
        int row, col, amount;

        while (true) {
            System.out.print("Enter row (1-3): ");
            row = sc.nextInt();

            System.out.print("Enter column (1-4): ");
            col = sc.nextInt();

            if (row < 1 || row > warehouse.length) {
                System.out.println("Invalid row!");
                continue;
            }

            if (col < 1 || col > warehouse[row - 1].length) {
                System.out.println("Invalid column!");
                continue;
            }

            if (warehouse[row - 1][col - 1] == -1) {
                System.out.println("Shelf is damaged!");
                return;
            }

            break;
        }

        while (true) {
            System.out.print("Enter restock amount: ");
            amount = sc.nextInt();

            if (amount <= 0) {
                System.out.println("Amount must be positive!");
                continue;
            }

            break;
        }

        warehouse[row - 1][col - 1] += amount;

        System.out.println("Restock successful!");
        System.out.println("Updated count: "
                + warehouse[row - 1][col - 1]);
    }
}