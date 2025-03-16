package algorithms.utils;

public class Array {
    public static void print(int[] array, String sortTitle) {
        System.out.print("Array after " + sortTitle + " sort: ");
        for(int i : array) {
            System.out.print("[" + i +"] ");
        }
        System.out.println();
    }
}
