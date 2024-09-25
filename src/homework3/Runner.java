package homework3;

import homework3.ex1.Apple;
import homework3.ex1.Apricot;
import homework3.ex1.Fruit;
import homework3.ex1.Garden;
import homework3.ex2.Guessing;
import homework3.ex2.Person;
import homework3.ex3.Burning;
import homework3.ex3.Tree;
import homework3.ex3.Uranus;
import homework3.ex4.Animal;
import homework3.ex4.Boat;
import homework3.ex4.Ruler;
import homework3.ex5.Review;

import java.time.LocalDateTime;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Garden<Fruit> appleFarm = () -> new Apple();
        Garden<Fruit> apricotFarm = () -> new Apricot();
        Fruit apple = appleFarm.grow();
        Fruit apricot = apricotFarm.grow();
        System.out.println("Получаем яблоко: " + apple);
        System.out.println("Получаем абрикос: " + apricot);

        System.out.println("--------------");

        Guessing<String> daidy = name -> name.length() % 2 == 0;
        Guessing<Person> fortuneTeller = person -> (person.getAge() + person.getHeight()) > 210;
        System.out.println(daidy.guess("Ivan"));
        Person person = new Person(30, 185);
        System.out.println(fortuneTeller.guess(person));

        System.out.println("--------------");

        Burning<Uranus> nuclearReactor = uranus -> System.out.println("зеленый свет вокруг!");
        Burning<Tree> bonfire = tree -> System.out.println("желто-красный свет вокруг!");
        Uranus uranium = new Uranus();
        Tree tree = new Tree();
        nuclearReactor.burn(uranium);
        bonfire.burn(tree);

        System.out.println("--------------");

        Ruler<Boat> boatMeter = board -> board.getLength();
        Ruler<Animal> animalMeter = animal -> animal.getBodyLength() + animal.getTailLength();
        Boat boat = new Boat(20);
        Animal animal = new Animal(10, 5);
        System.out.println("Boat: " + boatMeter.toMeasure(boat));
        System.out.println("Animal: " + animalMeter.toMeasure(animal));

        System.out.println("--------------");

        Review review1 = new Review(1, "отличный товар", 400, LocalDateTime.of(2024, 1, 25, 13, 37));
        Review review2 = new Review(5, "так себе товар", 300, LocalDateTime.of(2024, 1, 25, 13, 37));
        Review review4 = new Review(4, "плохой товар", 200, LocalDateTime.of(2024, 1, 25, 13, 37));
        Review review3 = new Review(2, "плохой товар", 200, LocalDateTime.of(2024, 1, 25, 13, 37));

        Comparator<Review> comparator = (r1, r2) -> {
            int likeComparison = Integer.compare(r2.getLikesCount(), r1.getLikesCount());
            if (likeComparison != 0) {
                return likeComparison;
            }
            int dateComparison = r1.getDate().compareTo(r2.getDate());
            if (dateComparison != 0) {
                return dateComparison;
            }

            return Integer.compare(r1.getId(), r2.getId());
        };

        TreeSet<Review> reviewsList = new TreeSet<>(comparator);

        reviewsList.add(review3);
        reviewsList.add(review4);
        reviewsList.add(review1);
        reviewsList.add(review2);

        reviewsList.forEach(System.out::println);
    }
}
