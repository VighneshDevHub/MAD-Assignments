package Day04;

import java.util.*;
class NegativeNumberException extends Exception{
    NegativeNumberException(String msg){
        super(msg);
    }
}

public class CustomException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number: ");
        int n = sc.nextInt();

        try {
            if (n < 0) {
                throw new NegativeNumberException("Number is Negative ");
            }
        }

        catch(NegativeNumberException e){
            System.out.println("Exception: "+e.getMessage());

            }




    }
}
