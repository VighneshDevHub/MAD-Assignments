package Day02;
interface Animal{
    public void bark();
}
interface Pet{
    public void run();
}
class Dog implements Animal, Pet{
    public void bark(){
        System.out.println("Barking...");
    }

    public void run(){
        System.out.println("Running...");
    }
}

public class Main {
    public static void main(String[] args) {

        Dog d = new Dog();
        d.bark();
        d.run();

    }
}
