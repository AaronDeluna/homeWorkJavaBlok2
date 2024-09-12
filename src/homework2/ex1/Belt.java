package homework2.ex1;

import homework2.Runner;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Belt {
    private static final int MAX_BAGGAGE_COUNT_ON_BELT = 10;
    private static final int BAGGAGE_NUMBER = 0;
    private static final int BAGGAGE_WEIGHT = 1;
    private ArrayBlockingQueue<Baggage> baggageQueue = new ArrayBlockingQueue<>(MAX_BAGGAGE_COUNT_ON_BELT);

    public void addToBelt(String fileName) {
        Scanner scanner = new Scanner(Runner.class.getClassLoader().getResourceAsStream(fileName));
        scanner.nextLine();
        while (scanner.hasNext()) {
            if (baggageQueue.size() == MAX_BAGGAGE_COUNT_ON_BELT) {
                System.out.println("Начинается загрузка на ленту");
                clearBelt();
            }
            String[] baggageInfo = scanner.nextLine().split(";");
            baggageQueue.add(new Baggage(baggageInfo[BAGGAGE_NUMBER],
                    Integer.parseInt(baggageInfo[BAGGAGE_WEIGHT])));
        }

        clearBelt();
    }

    public void clearBelt() {
        System.out.println("Лента загружена, начинается выдача багажа");
        while (!baggageQueue.isEmpty()) {
            System.out.println(baggageQueue.remove().getNumber() + "\t- " + " выдан");
        }
        System.out.println("Лента пустая, закончена выдача багажа");
    }
}
