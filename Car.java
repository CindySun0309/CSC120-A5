import java.util.ArrayList;

public class Car {
    private ArrayList passenger;
    int maxCapacity;

    public Car(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.passenger = new ArrayList<Passenger>(maxCapacity);
    }

    public int getCapacity(){
        return this.maxCapacity;
    }

    public int seatsRemaining(){
        return this.maxCapacity - this.passenger.size();
    }

    public void addPassenger(Passenger p) {
        if (seatsRemaining() > 0) {
            passenger.add(p);
            System.out.println("Successfully added passenger" + p + "!");
        }
        else {
            throw new RuntimeException("Error! The car is at max capacity!");
        }
    }

    public void removePassenger(Passenger p) {
        if (passenger.contains(p)) {
            passenger.remove(p);
            System.out.println("Successfully removed passenger" + p + "!");
        }
        else {
            throw new RuntimeException("Error! Does not have this passenger abroad!");
        }
    }

    public void printManifest() {
        if (seatsRemaining() == this.maxCapacity) {
            System.out.println("This car is EMPTY.");
        }
        if (seatsRemaining() < this.maxCapacity) {
            System.out.println("Current passengers abroad:");
            System.out.println(this.passenger);
        }
    }

    public static void main() {
        Car myCar = new Car(10);
        myCar.getCapacity();
        }


        
}