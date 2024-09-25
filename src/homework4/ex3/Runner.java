package homework4.ex3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Runner {
    private static final int MIN_HEIGHT = 1000;
    private static final int MAX_SKYSCRAPERS = 3;
    public static void main(String[] args) {
        List<Skyscraper> skyscrapers = new ArrayList<>(List.of(
                new Skyscraper("Всемирный торговый центр", 541),
                new Skyscraper("Шанхайская башня", 632),
                new Skyscraper("Бурдж-Халифа", 828),
                new Skyscraper("Международный финансовый центр Пинань", 599),
                new Skyscraper("Абрадж аль-Бейт", 601),
                new Skyscraper("Всемирный центр Лотте", 555),
                new Skyscraper("Бурдж-Халифа", 828)
        ));

        List<Skyscraper> correctSkyscrapers = skyscrapers.stream()
                .distinct()
                .toList();

        correctSkyscrapers.stream()
                .limit(MAX_SKYSCRAPERS)
                .forEach(System.out::println);

        System.out.println("--------------");

        Optional<Skyscraper> maxHeath = correctSkyscrapers.stream()
                .max(Comparator.comparingInt(Skyscraper::getHeight));

        maxHeath.ifPresent(skyscraper ->
                System.out.println("Самый высокий небоскреб: " + skyscraper));

        System.out.println("--------------");

        System.out.println("Небоскребы выше километра:");
        correctSkyscrapers.stream()
                .filter(skyscraper -> skyscraper.getHeight() > MIN_HEIGHT)
                .findAny()
                .ifPresentOrElse(
                        skyscraper -> correctSkyscrapers.stream()
                                .filter(s -> s.getHeight() > MIN_HEIGHT)
                                .forEach(System.out::println),
                        () -> System.out.println("Небоскребов выше километра - нет.")
                );
    }
}
