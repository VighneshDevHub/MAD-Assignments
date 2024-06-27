package Day02;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

        public static void main(String[] args) {

            List<String> list = new LinkedList<>();

            list.add("Dog");
            list.add("Cat");
            list.add("Horse");

            System.out.println("List: "+list);
            System.out.println("Element at index 1: " +list.get(1));

            list.remove("Cat");
            System.out.println("List after removal: "+list);
        }
    }

