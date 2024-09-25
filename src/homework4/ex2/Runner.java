package homework4.ex2;

import java.util.HashSet;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>(Set.of("тон", "тополь", "боль", "рой", "стройка"));

        long count = words.stream()
                .mapToLong(word -> word.chars()
                        .filter(ch -> ch == 'о')
                        .count())
                .sum();

        System.out.println("Количество слов, с буквой о: " + count);
    }
}
