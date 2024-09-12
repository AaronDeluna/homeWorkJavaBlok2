package homework2.ex1;

public enum BaggageType {
    LIGHT(5),
    MEDIUM(10),
    HEAVY(10),
    ;

    private int baggage;

    BaggageType(int baggage) {
        this.baggage = baggage;
    }

    public int getBaggageWeight() {
        return baggage;
    }
}
