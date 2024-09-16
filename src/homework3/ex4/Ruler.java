package homework3.ex4;

@FunctionalInterface
public interface Ruler<T> {
    Integer toMeasure(T input);
}
