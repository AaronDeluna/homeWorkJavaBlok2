package homework4.ex1;

public class Car {
    private LicensePlate licensePlate;

    public Car(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        return "Car{"
                + "licensePlate="
                + licensePlate + '}';
    }
}
