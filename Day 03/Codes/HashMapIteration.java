package Day02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapIteration {
    public static void main(String[] args) {
        HashMap<String, Integer> m = new HashMap<>();
        m.put("Mango", 1);
        m.put("Apple", 2);
        m.put("Banana", 3);

        System.out.println("HashMap Before Removal: " + m);

        Iterator<Map.Entry<String, Integer>> iterator = m.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getKey().equals("Apple")) {
                iterator.remove();
            }
        }
        System.out.println("Updated HashMap: " + m);
    }
}
