import java.util.Scanner;

public class code_pgee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter pattern size: ");
        int size = sc.nextInt();

        for (int i = 1; i <= size; i++) {
            if (i == 3) {
                continue; // Skips row 3
            }

            for (int j = 1; j <= i; j++) {
                if (j == 5) {
                    break; // Stops inner loop at column 5
                }

                System.out.print("* ");
            }

            System.out.println();
        }

        sc.close();
    }
}