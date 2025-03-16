package algorithms.sorts;

import algorithms.structs.SortResult;
import algorithms.utils.Array;

public class Bubble {
    public static SortResult sort(int[] array) {
        long startTime = System.nanoTime();
        long operationAmount = 1; // init swapped

        boolean swapped = false;

        operationAmount += 2; // i, j = 0
        for(int i = 0; i < array.length - 1; i++) {
            swapped = false;
            operationAmount += 2; // loop i < array.lenght & swapped = false

            for(int j = 0; j < array.length - 1; j++) {
                operationAmount += 2; // loop j < array.lenght & array[j] > array[j + 1]

                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;

                    operationAmount += 4; // swapped
                }

                operationAmount++; // j++
            }

            if(!swapped) break;

            operationAmount += 2;  // i++ & if(!swapped)
        }

        long timeElapsed = System.nanoTime() - startTime;

        Array.print(array, "bubble");

        return new SortResult(operationAmount, timeElapsed);
    }
}
