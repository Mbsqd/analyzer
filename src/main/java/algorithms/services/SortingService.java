package algorithms.services;

import java.util.ArrayList;

import algorithms.structs.SortResult;

public class SortingService {   // клас для збережння та опрацювання результатів одного алгоритму сортування
    private String sortTitle;
    private int dataAmount;

    private ArrayList<Long> operationsAmountArray = new ArrayList<>();
    private ArrayList<Long> timeElapsedArray = new ArrayList<>();

    private long avarageOperationsAmount;
    private long avarageTimeElapsed;

    private void initAvarageOperationsAmount() {
        if(operationsAmountArray.isEmpty()) return;

        this.avarageOperationsAmount = 0;
        for(long operation : operationsAmountArray) {
            this.avarageOperationsAmount += operation;
        }
        avarageOperationsAmount = avarageOperationsAmount / operationsAmountArray.size();
    }

    private void initAvarageTimeElapsed() {
        if(timeElapsedArray.isEmpty()) return;

        this.avarageTimeElapsed = 0;
        for(long time : timeElapsedArray) {
            this.avarageTimeElapsed += time;
        }
        avarageTimeElapsed = avarageTimeElapsed / timeElapsedArray.size();
    }

    public void setAvarageValues() {
        initAvarageOperationsAmount();
        initAvarageTimeElapsed();
    }

    public SortingService(String sortTitle) {
        this.sortTitle = sortTitle;
    }

    public void setDataAmount(int dataAmount) {
        this.dataAmount = dataAmount;
    }

    public void setOneAlgorithmResult(SortResult result) {
        this.operationsAmountArray.add(result.getOperationAmount());
        this.timeElapsedArray.add(result.getTimeElapsed());
    }

    public String getSortTittle() {
        return sortTitle;
    }

    public int getInputDataAmount() {
        return dataAmount;
    }

    public long getOperationAmount() {
        return avarageOperationsAmount;
    }

    public long getTimeElapsed() {
        return avarageTimeElapsed;
    }

}
