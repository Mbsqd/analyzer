package algorithms.structs;

public class SortResult {
    public long operationAmount;
    public long timeElapsed;

    public SortResult(long operationAmount, long timeElapsed) {
        this.operationAmount = operationAmount;
        this.timeElapsed = timeElapsed;
    }

    public long getOperationAmount() {
        return operationAmount;
    }

    public long getTimeElapsed() {
        return timeElapsed;
    }
}
