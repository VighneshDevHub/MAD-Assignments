package Day02;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Mango");
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println("List: "+list);
        System.out.println("Element at index 1: " +list.get(1));

        list.remove("Banana");
        System.out.println("List after removal: "+list);
    }
}
