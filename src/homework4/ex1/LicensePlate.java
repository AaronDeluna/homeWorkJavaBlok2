package homework4.ex1;

/**
 * Номерной знак.
 */
public class LicensePlate {
    private final char seriesLetter;
    private final int number;
    private final String seriesLetters;
    private final int regionCode;

    public LicensePlate(char seriesLetter, int number, String seriesLetters, int regionCode) {
        this.seriesLetter = seriesLetter;
        this.number = number;
        this.seriesLetters = seriesLetters;
        this.regionCode = regionCode;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.format("%c%03d%s%d", seriesLetter, number, seriesLetters, regionCode);
    }
}
