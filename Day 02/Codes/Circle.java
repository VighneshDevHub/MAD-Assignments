package Day02;

public class Circle {
    double rad;

    void setData(double rad){
        this.rad = rad;
    }

    void getArea(){
        System.out.println("Area of Circle: "+(Math.PI*rad*rad));
    }

    public static void main(String[] args) {

        Circle c = new Circle();
        c.setData(15);
        c.getArea();
    }
}
