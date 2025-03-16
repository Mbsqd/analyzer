package algorithms.services;

import java.util.Random;
import algorithms.structs.ExperimentResult;

public class ExperimentService {
    private final Random RANDOM = new Random();
    private int[] array;
    private int min, max, start, end, step, sampling;

    private void fillArray() {
        for(int i = 0; i < array.length; i++) {
            array[i] = RANDOM.nextInt(this.max - this.min) + this.min;
        }
    }

    private void resizeArray(int size) {
        array = new int[size];
        fillArray();
    }

    public ExperimentService(int min, int max, int start, int end, int step, int sampling) {
        if(min >= max) {
            throw new IllegalArgumentException("Minimal value must be less than max value");
        } else if (start >= end) {
            throw new IllegalArgumentException("Start value must be less than end value");
        } else if (step <= 0 || sampling <= 0) {
            throw new IllegalArgumentException("Step and sampling must be positive values, > 0");
        }

        this.min = min;
        this.max = max;
        this.start = start;
        this.end = end;
        this.step = step;
        this.sampling = sampling;
    }

    public void Start() {
        ExperimentResult results = new ExperimentResult();  // створюємо об'єкт класу, який зберігає опрацьовує результати єксперименту

        for(int dataSize = start; dataSize <= end; dataSize += step) {
            results.initSortingArrays();
            resizeArray(dataSize);

            results.setDataAmount(dataSize);    // зберігаємо кількість вхідних даних
            for(int sample = 1; sample <= sampling; sample++) {
                results.setOneAlgorithmResult(array.clone());   // зберігаємо результат однієї ітерації експерименту
                fillArray();    // оновлюємо дані в масиві
            }

            results.saveValues();   // зберігаємо результати роботи алгоритмів для поточної кількості вкідних даних
        }

        results.saveResults();  // зберігаємо результати роботи всіх алгоритмів та записуємо їх у файл
    }
}
