package algorithms.sorts;

import algorithms.structs.SortResult;
import algorithms.utils.Array;

public class Comb {
    private static int operationAmount;

    private static int nextGap(int gap) {
        operationAmount += 2;   // gap/3 & if

        gap = (gap*10/13);
        if(gap < 1) return 1;
        return gap;
    }

    public static SortResult sort(int[] array) {
        long startTime = System.nanoTime();

        operationAmount = 0;
        operationAmount += 3; // init n & gap & swapped

        int n = array.length;
        int gap = n;
        boolean swapped = true;

        while(gap != 1 || swapped) {
            operationAmount += 5; // if gap & swapped & call nextGap & swapped = false & init i

            gap = nextGap(gap);
            swapped = false;

            for(int i = 0; i < n - gap; i++) {
                operationAmount += 2; // i < n & if

                if(array[i] > array[i + gap]) {
                    int temp = array[i];
                    array[i] = array[i + gap];
                    array[i + gap] = temp;
                    swapped = true;

                    operationAmount += 4; // swapped
                }

                operationAmount++; // i++
            }
        }

        long timeElapsed = System.nanoTime() - startTime;

        Array.print(array, "comb");

        return new SortResult(operationAmount, timeElapsed);
    }
}
