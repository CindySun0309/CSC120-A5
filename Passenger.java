public class Passenger {
    
    private String name;
 
    public Passenger(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void boardCar(Car c) {
        try {
            c.addPassenger(this);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getOffCar(Car c) {
        try {
            c.removePassenger(this);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

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

