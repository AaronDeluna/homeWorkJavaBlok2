package homework2.ex1;

public enum BaggageType {
    LIGHT(5),
    MEDIUM(10),
    HEAVY(10),
    ;

    private int baggageLimit;

    BaggageType(int baggage) {
        this.baggageLimit = baggage;
    }

    public int getBaggageWeight() {
        return baggageLimit;
    }
}
