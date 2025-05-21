import org.json.JSONObject;

class Car {
    String make;
    String model;
    int year;

    Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
}

public class P2 {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 2020);
        JSONObject json = new JSONObject(car);
        System.out.println(json.toString(2));
    }
}
