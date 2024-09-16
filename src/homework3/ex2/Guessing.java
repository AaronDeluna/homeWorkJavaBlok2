package homework3.ex2;

@FunctionalInterface
public interface Guessing<T> {
    boolean guess(T input);
}
