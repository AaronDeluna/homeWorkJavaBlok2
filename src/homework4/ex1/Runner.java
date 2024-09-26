package homework4.ex1;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Runner {
    private static final int MIN_CAR_INDEX = 1;
    private static final int MAX_CAR_INDEX = 51;
    private static final int GOVERNMENT_NUMBER_MIN = 40;
    private static final int GOVERNMENT_NUMBER_MAX = 49;

    /**
     * Данные для машины A
     */
    private static final char SERIES_LETTER_A = 'а';
    private static final String SERIAL_SUFFIX_A = "ан";
    private static final int REGION_CODE_A = 799;

    /**
     * Данные для машины B
     */
    private static final char SERIES_LETTER_B = 'к';
    private static final String SERIAL_SUFFIX_B = "се";
    private static final int REGION_CODE_B = 178;

    public static void main(String[] args) {
        List<Car> carListA = createCarList(SERIES_LETTER_A, SERIAL_SUFFIX_A, REGION_CODE_A);
        List<Car> carListB = createCarList(SERIES_LETTER_B, SERIAL_SUFFIX_B, REGION_CODE_B);

        Stream<Car> allCarStream = Stream.concat(carListA.stream(), carListB.stream());

        allCarStream.filter(car -> isGovernmentPlateNumber(car))
                .forEach(car -> System.out.println(car.getLicensePlate()));
    }

    /**
     * Проверяет, является ли номерной знак автомобиля государственным.
     *
     * @param car объект автомобиля.
     * @return true, если номерной знак государственный, иначе false.
     */
    private static boolean isGovernmentPlateNumber(Car car) {
        int sereNumber = car.getLicensePlate().getNumber();
        return sereNumber >= GOVERNMENT_NUMBER_MIN && sereNumber <= GOVERNMENT_NUMBER_MAX;
    }

    /**
     * Создает объект автомобиля с заданным номерным знаком.
     *
     * @param seriesLetter буква серии номера.
     * @param index номер автомобиля.
     * @param seriesLetters буквы серии номера.
     * @param regionCode код региона.
     * @return объект автомобиля с указанным номерным знаком.
     */
    private static Car createCarWithLicensePlate(char seriesLetter, int index,
                                                 String seriesLetters, int regionCode) {
        return new Car(new LicensePlate(seriesLetter, index, seriesLetters, regionCode));
    }

    /**
     * Создает список автомобилей с номерами на основе заданных параметров.
     *
     * @param seriesLetter  буква серии для номера автомобиля.
     * @param seriesLetters строка с дополнительными буквами серии.
     * @param regionCode    код региона для номера.
     * @return список автомобилей с номерами.
     */
    private static List<Car> createCarList(char seriesLetter, String seriesLetters, int regionCode) {
        return IntStream.range(MIN_CAR_INDEX, MAX_CAR_INDEX)
                .mapToObj(index -> createCarWithLicensePlate(seriesLetter, index,
                        seriesLetters, regionCode))
                .toList();
    }
}
