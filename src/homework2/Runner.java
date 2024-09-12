package homework2;

import homework2.ex1.BaggageType;
import homework2.ex1.Belt;
import homework2.ex1.Customs;

import java.util.Map;

public class Runner {
    public static void main(String[] args) {
        Belt belt = new Belt();
        String fileName = "luggage.csv";
        belt.addToBelt(fileName);

        System.out.println("----------------------");

        Customs customs = new Customs();
        System.out.println(
                "Легкий - " + customs.calculateTotalWeightByCategory(fileName).get(BaggageType.LIGHT)
                + "\nсредний - " + customs.calculateTotalWeightByCategory(fileName).get(BaggageType.MEDIUM)
                + "\nтяжелый - " + customs.calculateTotalWeightByCategory(fileName).get(BaggageType.HEAVY)
        );
    }
}
