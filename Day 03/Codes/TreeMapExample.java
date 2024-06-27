package Day03;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        Map<String, Integer> m = new TreeMap<>();

        m.put("Apple", 1);
        m.put("Banana", 2);
        m.put("Cherry", 3);
        System.out.println("Map: " + m);

        m.remove("Banana");

        System.out.println("Map after removal: " + m);
        System.out.println("Value for 'Cherry':" + m.get("cherry"));
    }

    }
