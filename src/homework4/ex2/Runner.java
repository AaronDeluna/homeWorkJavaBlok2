package homework4.ex2;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(List.of("тон", "тополь", "боль", "рой", "стройка"));

        long count = words.stream()
                .mapToLong(word -> word.chars()
                        .filter(ch -> ch == 'о')
                        .count())
                .sum();

        System.out.println("Количество слов, с буквой о: " + count);
    }
}
