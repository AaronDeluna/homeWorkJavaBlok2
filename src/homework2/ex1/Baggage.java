package homework2.ex1;

public class Baggage {
    private String number;
    private int weight;

    public Baggage(String number, int weight) {
        this.number = number;
        this.weight = weight;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
