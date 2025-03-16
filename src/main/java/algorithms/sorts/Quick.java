package algorithms.sorts;

import algorithms.structs.SortResult;
import algorithms.utils.Array;

public class Quick {
    private static int operationAmount;

    public static SortResult sort(int[] array) {
        long startTime = System.nanoTime();

        operationAmount = 1;    // init n

        int n = array.length;

        quickSort(array, 0, n - 1);

        long timeElapsed = System.nanoTime() - startTime;

        Array.print(array, "quick");

        return new SortResult(operationAmount, timeElapsed);
    }

    private static void swap(int[] arr, int i, int j) {
        operationAmount++; // if i != j
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            operationAmount += 3;  // 3 swapped
        }
    }

    private static int partition(int[] arr, int low, int high) {
        operationAmount += 3;  // init pivot & i & j

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            operationAmount += 2; // if j < high & arr[j] < pivot
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
                operationAmount += 2;   // i++ & call swap
            }

            operationAmount++;  // j++
        }
        operationAmount++;  // swap

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void quickSort(int[] arr, int low, int high) {
        operationAmount++;  // if low < high
        if (low < high) {
            operationAmount += 3; // init p & call 2 recursive functions

            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
