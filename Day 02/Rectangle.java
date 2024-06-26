package Day02;

public class Rectangle {
    int l,b;

    Rectangle(int l,int b){
        this.l= l;
        this.b = b;
    }

    void getArea(){
        System.out.println("Area Of Rectangle: "+(l*b));
    }

    public static void main(String[] args) {
        Rectangle rec  = new Rectangle(10,20);
        rec.getArea();

    }
}
