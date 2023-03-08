import java.util.ArrayList;

/**
 * this class creates cars for the train
 */
public class Car {

    /**
     * passengers: a list for passengers
     * maxCapacity: the maximum capacity for passengers
     * passengerNumber: the number of passengers onboard
     */
    private ArrayList<Passenger> passengers;
    public int maxCapacity;
    public int passengerNumber;

    /**
     * construct a car
     * @param maxCapacity
     */
    public Car(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.passengers = new ArrayList<Passenger>(maxCapacity);
        this.passengerNumber = 0;
    }

    /**
     * gets the maximum capacity for passengers
     * @return the maximum capacity for passengers
     */
    public int getCapacity(){
        return this.maxCapacity;
    }

    /**
     * gets the remaining seats on the car
     * @return the remaining seats on the car
     */
    public int seatsRemaining(){
        return this.maxCapacity - this.passengerNumber;
    }

    /**
     * add a passenger on the car
     * @param p a passenger
     */
    public void addPassenger(Passenger p) {
        if ((seatsRemaining() > 0) && !(passengers.contains(p))) {
            passengers.add(p);
            this.passengerNumber += 1;
            System.out.println("Successfully added passenger " + p.getName() + "!");
        }
        else if (passengers.contains(p)){
            System.out.println(p.getName() + " is already onboard!");
        }
        else {
            throw new RuntimeException("Error! Cannot add " + p.getName() +  "! The car is at max capacity.");
        }
    }

    /**
     * remove a passenger from the car
     * @param p a passenger
     */
    public void removePassenger(Passenger p) {
        if (passengers.contains(p)) {
            passengers.remove(p);
            this.passengerNumber -= 1;
            System.out.println("Successfully removed passenger " + p.getName() + "!");
        }
        else {
            throw new RuntimeException("Error! Does not have " + p.getName() + " onbroad!");
        }
    }

    /**
     * print the manifest of the car, including
     * the number of passengers currently onboard
     * and the names of passengers
     */
    public void printManifest() {
        if (seatsRemaining() == this.maxCapacity) {
            System.out.println("This car is EMPTY.");
        }
        if (seatsRemaining() < this.maxCapacity) {
            System.out.println("Current passengers onbroad:" + this.passengerNumber);
            System.out.println("Names of passengers:");
            for (int i = 0; i < passengers.size(); i++) {
                System.out.println(this.passengers.get(i).getName());
            }
        }
    }     
    
    /**
     * the main() is to test functions in the class
     * @param args
     */
    public static void main(String[] args) {
        Car newCar = new Car(2);
        Passenger me = new Passenger("Cindy");
        Passenger amy = new Passenger("Amy");
        Passenger jack = new Passenger("Jack");
        Passenger diego = new Passenger("Diego");
        
        amy.boardCar(newCar);
        System.out.println(newCar.seatsRemaining());
        me.boardCar(newCar);
        me.boardCar(newCar);
        me.getOffCar(newCar);
        diego.boardCar(newCar);
        jack.getOffCar(newCar);
        me.boardCar(newCar);


        newCar.printManifest();


        newCar.addPassenger(amy);
        amy.boardCar(newCar);
}
}