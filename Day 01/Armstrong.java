// Student Name: Vighnesh Santosh Salunkhe
// Q. WAP to check given number is Armstrong or not

import java.util.*;

public class Armstrong {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        int org = num;
        int sum = 0;
        int numdigit = String.valueOf(num).length();

        while (num != 0) {
            int digit = num% 10;
            sum += Math.pow(digit,numdigit );
            num /= 10;
        }

        if (sum == org) {
            System.out.println(org + " is an Armstrong number.");
        } else {
            System.out.println(org + " is not an Armstrong number.");
        }

    }
}
