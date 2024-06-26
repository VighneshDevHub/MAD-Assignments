package Day03;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();

        set.add("Banana");
        set.add("Apple");
        set.add("Cherry");

        System.out.println("Set: " + set);

        set.remove("Banana");
        System.out.println("Set after removal: " + set);
        System.out.println("Contains 'Cherry': " + set.contains("Cherry"));
    }
}