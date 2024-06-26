package Day02;

public class Rectangle1 {
    int l,b;

    void setData(int x, int y){
        l =x;
        b =y;
    }

    void getArea(){
        System.out.println("Area Of Rectangle: "+(l*b));
    }

    public static void main(String[] args) {
        Rectangle1 rec  = new Rectangle1();

        rec.setData(10,20);
        rec.getArea();

    }
}

