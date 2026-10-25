import java.util.Scanner;

public class code_susv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        int number = 0;

        while (number != -1) {
            System.out.print("Enter a number (-1 to stop): ");
            number = sc.nextInt();

            if (number == -1) {
                break;
            }

            total += number;
        }

        System.out.println("Final Total: " + total);
        sc.close();
    }
}