package Day03;
import java.util.*;

public class PrimeNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num, count =0;

        System.out.println("Enter a Number: ");
        num = sc.nextInt();

        for(int i= 1; i<=num; i++){
            if(num % i == 0){
                count++;
            }
        }
        if(count == 2){
            System.out.println(num+"  is Prime ");
        }
        else{
            System.out.println(num+" is Not Prime Number ");
        }
    }
}
