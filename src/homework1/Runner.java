package homework1;

import homework1.ex1.animal.Bird;
import homework1.ex1.animal.Dog;
import homework1.ex1.animal.Tiger;
import homework1.ex1.zoo.Zoo;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Bird bird = new Bird();
        Dog dog = new Dog();
        Tiger tiger = new Tiger();

        Zoo<Bird> zooBird = new Zoo<>(bird);
        Zoo<Dog> zooDog = new Zoo<>(dog);
        Zoo<Tiger> zooTiger = new Zoo<>(tiger);

        zooBird.getEntity().performAction();
        zooDog.getEntity().performAction();
        zooTiger.getEntity().performAction();


        System.out.println("-------------");


        List<Integer> januaryTemperatureList = new ArrayList<>(List.of(
                0, -1, -1, -2, -5, -6, -7, -8, -9, -10, -5, -5,
                -2, -7, -3, -1, -8, -9, -8, -8, -18, -20, -23, -24, -25, -9, -8, -7, -6, -5, -1));
        List<Integer> februaryTemperatureList = new ArrayList<>(List.of(
                -8, -10, -12, -13, -15, -16, -12, -7, -8, -10,
                -10, -9, -8, -8, -8, -9, -10, -9, -5, -6, -8, -7, -8, -9, -6, -5, -3, -1));
        List<Integer> totalTemperatureList = new ArrayList<>();
        totalTemperatureList.addAll(januaryTemperatureList);
        totalTemperatureList.addAll(februaryTemperatureList);

        int totalTemp = 0;
        for (int i = 0; i < totalTemperatureList.size(); i++) {
            totalTemp += totalTemperatureList.get(i);
        }

        int averageTemperature = totalTemp / totalTemperatureList.size();
        System.out.println("Средняя температура: " + averageTemperature);

        System.out.println("-------------");
        //Задание №3 Ресторанный гуру
        //Николай Петрович ходит по ресторанам. За 5 дней он был во множестве ресторанов.
        //Он обратился к вам, чтобы узнать в каком ресторане(ах) он был каждый день
        // (т.е. найти ресторан(ы) в которых он был и в понедельник, и во вторник, и в среду и тд).
        ArrayList<String> monday = new ArrayList<>(List.of("Чебуречная №1", "Реберная", "Андерсон", "Ниппон", "Фо бо"));
        ArrayList<String> tuesday = new ArrayList<>(List.of("Вареничная №1", "Пушкин", "Чебуречная №1", "Ниппон", "Реберная"));
        ArrayList<String> wednesday = new ArrayList<>(List.of("Реберная", "Арарат", "Майя", "Ниппон", "Таксим"));
        ArrayList<String> thursday = new ArrayList<>(List.of("Грех", "Ваниль", "Реберная", "Пянсе", "Фо бо"));
        ArrayList<String> friday = new ArrayList<>(List.of("Бёрдс", "Реберная", "Андерсон", "Ниппон", "Чифанька"));

        monday.retainAll(tuesday);
        monday.retainAll(wednesday);
        monday.retainAll(thursday);
        monday.retainAll(friday);

        System.out.println("Николай Петрович за неделю посетил каждый день следующие рестораны:");
        System.out.println(monday);
    }
}
