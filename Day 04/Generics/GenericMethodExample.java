package Day04;

public class GenericMethodExample {

    // A generic method that takes an array of any type and prints its elements
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create arrays of Integer, Double and String
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        String[] stringArray = { "Hello", "World", "Generics", "In", "Java" };

        // Call the generic method with different types of arrays
        System.out.println("Array of Integers:");
        printArray(intArray);

        System.out.println("Array of Doubles:");
        printArray(doubleArray);

        System.out.println("Array of Strings:");
        printArray(stringArray);
    }
}

