package Day03;

public class ExceptionHandling {
    public static void main(String[] args) {

        try{
            int [] num = {1,2,3};
            System.out.println(num[5]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Exception Caught: "+e.getMessage());
        }
    }
}
