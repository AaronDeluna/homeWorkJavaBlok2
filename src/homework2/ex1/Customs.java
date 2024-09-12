package homework2.ex1;

import homework2.Runner;

import java.util.*;

public class Customs {
    private static final int BAGGAGE_WEIGHT = 1;
    private Map<BaggageType, Integer> weightByCategory = new HashMap<>();

    public Map<BaggageType, Integer> calculateTotalWeightByCategory(String fileName) {
        Scanner scanner = new Scanner(Runner.class.getClassLoader().getResourceAsStream(fileName));
        scanner.nextLine();

        weightByCategory.put(BaggageType.LIGHT, 0);
        weightByCategory.put(BaggageType.MEDIUM, 0);
        weightByCategory.put(BaggageType.HEAVY, 0);

        while (scanner.hasNext()) {
            String[] baggageWeightInfo = scanner.nextLine().split(";");
            int weight = Integer.parseInt(baggageWeightInfo[BAGGAGE_WEIGHT]);
            if (weight < BaggageType.LIGHT.getBaggageWeight()) {
                addByCategory(BaggageType.LIGHT, weightByCategory, weight);
            } else if (weight < BaggageType.MEDIUM.getBaggageWeight()) {
                addByCategory(BaggageType.MEDIUM, weightByCategory, weight);
            } else {
                addByCategory(BaggageType.HEAVY, weightByCategory, weight);
            }
        }

        return weightByCategory;
    }

    private void addByCategory(BaggageType baggageType, Map<BaggageType, Integer> weightByCategory, int weight) {
        weightByCategory.put(baggageType, weightByCategory.getOrDefault(baggageType, 0) + weight);
    }
}
