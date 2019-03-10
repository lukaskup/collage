import java.time.LocalDate;

public class GUI0102{
    public static void main(String[] args){
        Vehicle vehicle = new Vehicle("Porshe", "911", 2018, LocalDate.of(2018, 8, 1));
        Car car = new Car("Tesla", "Model X", 2018, LocalDate.of(2018, 8, 1), LocalDate.of(2019, 1, 24),
                LocalDate.of(2019, 2, 14));
        Taxi taxi = new Taxi("Opel", "Astra", 2018, LocalDate.of(1997, 3, 23), LocalDate.of(2016, 8, 1),
                LocalDate.of(2012, 6, 1), LocalDate.of(2013, 8, 1));

        System.out.println(vehicle.toString());
        System.out.println("");
        System.out.println(car.toString());
        System.out.println("");
        car.setOverViewDate(LocalDate.of(2019, 3, 8));
        System.out.println(car.toString());
        System.out.println("");
        System.out.println(taxi.toString());
    }
}

class Vehicle{
    private String brand;
    private String model;
    private int prodYear;
    private LocalDate registerDate;

    Vehicle(String brand, String model, int prodYear, LocalDate registerDate){
        this.brand = brand;
        this.model = model;
        this.prodYear = prodYear;
        this.registerDate = registerDate;
    }

    @java.lang.Override
    public String toString(){
        return "Brand: " + this.brand + "\n" + "Model: " + this.model + "\n"
                + "Production year: " + this.prodYear + "\n" + "Register year: " + this.registerDate;
    }
}

class Car extends Vehicle{
    private LocalDate overViewDate;
    public LocalDate lastInsuranceDate;
    public LocalDate InsuranceExpirationDate;

    Car(String brand, String model, int prodYear, LocalDate registerDate, LocalDate overViewDate, LocalDate lastInsuranceDate){
        super(brand, model, prodYear, registerDate);
        this.overViewDate = overViewDate;
        this.lastInsuranceDate = lastInsuranceDate;
        this.InsuranceExpirationDate = lastInsuranceDate.plusDays(365);
    }

    @java.lang.Override
    public String toString() {
        return super.toString() + "\nLast overview date: " + this.overViewDate + "\nInsurance date: " + this.lastInsuranceDate
                + "\nInsurance expiration date: " + this.InsuranceExpirationDate;
    }

    public void setOverViewDate(LocalDate newInsuranceDate){
        this.lastInsuranceDate = newInsuranceDate;
    }
}

class Taxi extends Car{
    private LocalDate taxoMeterDate;

    Taxi(String brand, String model, int prodYear, LocalDate registerDate, LocalDate overViewDate, LocalDate lastInsuranceDate, LocalDate taxoMeterDate){
        super(brand, model, prodYear, registerDate, overViewDate, lastInsuranceDate);
        this.taxoMeterDate = taxoMeterDate;
        super.InsuranceExpirationDate = lastInsuranceDate.plusMonths(6);
    };

    @java.lang.Override
    public String toString() {
        return super.toString() + "\nLast taxometer date: " + this.taxoMeterDate;
    }

    public void setOverViewDate(LocalDate newInsuranceDate){
        this.lastInsuranceDate = newInsuranceDate;
    }
}

