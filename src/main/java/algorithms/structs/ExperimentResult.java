package algorithms.structs;

import java.util.ArrayList;

import algorithms.services.SortingService;
import algorithms.sorts.Bubble;
import algorithms.sorts.Comb;
import algorithms.sorts.Quick;
import algorithms.utils.CSVWriter;

public class ExperimentResult { // клас для збереження та опрацювання декількох алгоритмів
    private ArrayList<ArrayList<SortingService>> results;
    private ArrayList<SortingService> bubbleResults;
    private ArrayList<SortingService> quickResults;
    private ArrayList<SortingService> combResults;

    private SortingService bubble;
    private SortingService quick;
    private SortingService comb;

    private void saveResultToFile(String filename) {
        CSVWriter.SaveToCSV(results, filename);
        CSVWriter.SaveToDefaultCSV(results, filename);
    }

    public ExperimentResult() {
        results = new ArrayList<>();
        bubbleResults = new ArrayList<>();
        quickResults = new ArrayList<>();
        combResults = new ArrayList<>();
    }

    public void initSortingArrays() {
        bubble = new SortingService("Bubble");
        quick = new SortingService("Quick");
        comb = new SortingService("Comb");
    }

    public void setDataAmount(int dataSize) {
        bubble.setDataAmount(dataSize);
        quick.setDataAmount(dataSize);
        comb.setDataAmount(dataSize);
    }

    public void setOneAlgorithmResult(int[] array) {
        bubble.setOneAlgorithmResult(Bubble.sort(array));
        quick.setOneAlgorithmResult(Quick.sort(array));
        comb.setOneAlgorithmResult(Comb.sort(array));
    }

    public void saveValues() {
        bubble.setAvarageValues();
        quick.setAvarageValues();
        comb.setAvarageValues();

        bubbleResults.add(bubble);
        quickResults.add(quick);
        combResults.add(comb);
    }

    public void saveResults() {
        results.add(bubbleResults);
        results.add(quickResults);
        results.add(combResults);

        saveResultToFile("./experiment/results");
    }
}
