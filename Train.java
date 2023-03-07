import java.util.ArrayList;

public class Train {

    private final Engine engine;
    private ArrayList<Car> cars;

    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        this.engine = new Engine(fuelType, fuelCapacity);
        this.cars = new ArrayList<Car>(nCars);
        for (int i = 0; i < nCars; i++ ) {
            Car somecar = new Car(passengerCapacity);
            this.cars.add(somecar);
        }
    }


}
