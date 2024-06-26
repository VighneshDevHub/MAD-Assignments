package Day04;
 class ArrayContainer<T> {
    private T[] array;

    public ArrayContainer(T[] array) {
        this.array = array;
    }
    public void printArray() {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

public class GenericClassObject {
    public static void main(String[] args) {

        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        String[] stringArray = { "Generic", "Class", "Object", "Example" };

        // Creating  objects
        ArrayContainer<Integer> intContainer = new ArrayContainer<>(intArray);
        ArrayContainer<Double> doubleContainer = new ArrayContainer<>(doubleArray);
        ArrayContainer<String> stringContainer = new ArrayContainer<>(stringArray);

        System.out.println("Array of Integers:");
        intContainer.printArray();

        System.out.println("Array of Doubles:");
        doubleContainer.printArray();

        System.out.println("Array of Strings:");
        stringContainer.printArray();
    }
}

