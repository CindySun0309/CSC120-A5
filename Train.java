import java.util.ArrayList;

/**
 * this class creates a train that contains many cars, 
 * an engine, and can board passengers
 */
public class Train {

    /**
     * engine: the engine of the train
     * cars: an arraylist of cars in the train
     */
    private final Engine engine;
    private ArrayList<Car> cars;

    /**
     * constructs a train
     * @param fuelType the fuel type of the train
     * @param fuelCapacity the maximum capacity of fuel
     * @param nCars the number of cars of the train
     * @param passengerCapacity the maximun capacity of passengers
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        this.engine = new Engine(fuelType, fuelCapacity);
        this.cars = new ArrayList<Car>(nCars);
        for (int i = 0; i < nCars; i++ ) {
            Car somecar = new Car(passengerCapacity);
            this.cars.add(somecar);
        }
    }

    /**
     * gets the engine of the train
     * @return the engine of the train
     */
    public Engine getEngine() {
        return this.engine;
    }

    /**
     * get one car of the train
     * @param i the car of the train with number i in the arraylist
     * @return the car of the train with its actual number in real life
     */
    public Car getCar(int i) {
        return this.cars.get(i-1);
    }

    /**
     * get the maximum capacity of passengers for all cars of the train
     * @return the maximum capacity of passengers for all cars of the train
     */
    public int getMaxCapacity() {
        int maxCapacity = 0;
        for (int i = 0; i < cars.size(); i++ ) {
            maxCapacity += cars.get(i).getCapacity();
        }
        return maxCapacity;
    }

    /**
     * gets the remained seats for all cars of the train
     * @return the remained seats for all cars of the train
     */
    public int seatsRemaining() {
        int remainedSeats = 0;
        for (int i = 0; i < cars.size(); i++ ) {
            remainedSeats += cars.get(i).seatsRemaining();
        }
        return remainedSeats;
    }

    /**
     * prints the manifest for the train
     */
    public void printManifest() {
        for (int i = 0; i < cars.size(); i++ ) {
            cars.get(i).printManifest();
        }
    }
        
    /**
     * the main() is to test functions in the class
     * @param args
     */
    public static void main(String[] args) {
        Train newTrain = new Train(FuelType.STEAM, 10, 2, 1);
        //newTrain.getMaxCapacity();
        //newTrain.seatsRemaining();
        //newTrain.printManifest();
        Passenger me = new Passenger("Cindy");
        Passenger amy = new Passenger("Amy");
        //newTrain.getCar(1).addPassenger(me);
        //newTrain.getCar(1).addPassenger(me);
        //newTrain.getCar(1).addPassenger(amy);
        amy.boardCar(newTrain.getCar(1));
        me.boardCar(newTrain.getCar(1));
        System.out.println(newTrain.getMaxCapacity());
        System.out.println(newTrain.seatsRemaining());
        newTrain.printManifest();
        //amy.getOffCar(newTrain.getCar(1));
        System.out.println(newTrain.seatsRemaining());
        //newTrain.printManifest();


    }
}
