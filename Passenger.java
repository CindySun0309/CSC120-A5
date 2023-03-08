/**
 * This class creates passengers who are ready to
 * boardCar() and getOffCar()
 */
public class Passenger {
    
    /**
     * the name of the passenger
     */
    private String name;
 
    /**
     * construct a new passenger with a given name
     * @param name
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * gets the name of a passenger
     * @return the name of this passenger
     */
    public String getName(){
        return this.name;
    }

    /**
     * board the passenger on a car (created by the Car class)
     * @param c a car created by the Car class
     */
    public void boardCar(Car c) {
        try {
            c.addPassenger(this);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * get the passenger off a car (created by the Car class)
     * @param c a car created by the Car class
     */
    public void getOffCar(Car c) {
        try {
            c.removePassenger(this);
        } catch (Exception e) {
            System.out.println(e);
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
        
        amy.boardCar(newCar);
        System.out.println(newCar.seatsRemaining());
        me.boardCar(newCar);
        me.boardCar(newCar);
        me.getOffCar(newCar);

        newCar.printManifest();

    }
}

