package Day03;

import java.util.HashSet;
import java.util.Set;
public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple");
        System.out.println("Set: "+set);

        set.remove("Banana");
        System.out.println("Set after removal: "+set);

        System.out.println("Contains 'Cherry':"+ set.contains("Cherry"));
    }
}
