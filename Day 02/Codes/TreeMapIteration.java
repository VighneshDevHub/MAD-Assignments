// File path: src/Day02/TreeMapRemove.java

package Day02;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapIteration {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Mango", 1);
        map.put("Apple", 2);
        map.put("Banana", 3);

        System.out.println("TreehMap Before Removal: " + map);
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getKey().equals("Apple")) {
                iterator.remove();
            }
        }
        System.out.println("Updated TreeMap: " + map);
    }
}
