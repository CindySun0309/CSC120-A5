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

    public Engine getEngine() {
        return this.engine;
    }

    public Car getCar(int i) {
        return this.cars.get(i);
    }

    public int getMaxCapacity() {
        int maxCapacity = 0;
        for (int i = 0; i < cars.size(); i++ ) {
            maxCapacity += cars.get(i).getCapacity();
        }
        return maxCapacity;
    }

    public int seatsRemaining() {
        int remainedSeats = 0;
        for (int i = 0; i < cars.size(); i++ ) {
            remainedSeats += cars.get(i).seatsRemaining();
        }
        return remainedSeats;
    }


    public void printManifest() {
        for (int i = 0; i < cars.size(); i++ ) {
            cars.get(i).printManifest();
        }
    }
        

    public static void main(String[] args) {
        

        Train newTrain = new Train(FuelType.STEAM, 10, 2, 2);
        newTrain.getMaxCapacity();
        newTrain.seatsRemaining();
        newTrain.printManifest();

    }
}
