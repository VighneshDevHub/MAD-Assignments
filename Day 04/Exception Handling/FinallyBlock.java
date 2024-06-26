package Day04;

public class FinallyBlock {
    public static void main(String[] args) {
        try{
            int a = 4;
            int b = 0;
            int c = a/b;
            System.out.println("Result: "+c);
        }
        catch(ArithmeticException e){
            System.out.println("Exception Caught: "+e.getMessage());
        }
        finally {

                System.out.println("Code always Executed");
            }
    }


}

