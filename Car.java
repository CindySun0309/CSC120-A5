import java.util.ArrayList;

public class Car {
    private ArrayList<Passenger> passengers;
    int maxCapacity;
    int passengerNumber;

    public Car(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.passengers = new ArrayList<Passenger>(maxCapacity);
        this.passengerNumber = 0;
    }

    public int getCapacity(){
        return this.maxCapacity;
    }

    public int seatsRemaining(){
        return this.maxCapacity - this.passengerNumber;
    }

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

    public void printManifest() {
        if (seatsRemaining() == this.maxCapacity) {
            System.out.println("The car is EMPTY.");
        }
        if (seatsRemaining() < this.maxCapacity) {
            System.out.println("Current passengers abroad:" + this.passengerNumber);
            System.out.println("Names of passengers:");
            for (int i = 0; i < passengers.size(); i++) {
                System.out.println(this.passengers.get(i).getName());
            }
        }
    }       
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