package homework4.ex1;

/**
 * Номерной знак.
 */
public class LicensePlate {
    private char seriesLetter;
    private int number;
    private String seriesLetters;
    private int regionCode;

    public LicensePlate(char seriesLetter, int number, String seriesLetters, int regionCode) {
        this.seriesLetter = seriesLetter;
        this.number = number;
        this.seriesLetters = seriesLetters;
        this.regionCode = regionCode;
    }

    public char getSeriesLetter() {
        return seriesLetter;
    }

    public void setSeriesLetter(char seriesLetter) {
        this.seriesLetter = seriesLetter;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSeriesLetters() {
        return seriesLetters;
    }

    public void setSeriesLetters(String seriesLetters) {
        this.seriesLetters = seriesLetters;
    }

    public int getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(int regionCode) {
        this.regionCode = regionCode;
    }

    @Override
    public String toString() {
        return String.format("%c%03d%s%d", seriesLetter, number, seriesLetters, regionCode);
    }
}
