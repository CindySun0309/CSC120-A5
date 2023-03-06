import java.util.ArrayList;
public class Engine {

    private FuelType fuelType;
    double FuelLevelmax;
    double FuelLevelcurrent;
    
    public Engine(FuelType fuelType, double FuelLevelmax){
        this.fuelType = fuelType;
        this.FuelLevelmax = FuelLevelmax;
        this.FuelLevelcurrent = this.FuelLevelmax;
    }


    public FuelType getFuelType(){
        return this.fuelType;
    }

    public double getFuelLevelmax(){
        return this.FuelLevelmax;
    }

    public double getFuelLevelcurrent(){
        return this.FuelLevelcurrent;
    }

    public void refuel(){
        this.FuelLevelcurrent = this.FuelLevelmax;
    }

    public void go(){
        if (this.FuelLevelcurrent > 0) {
            this.FuelLevelcurrent -= 1;
            System.out.println("Remaining fuel level is:" + getFuelLevelcurrent());
        }
        else { 
            throw new RuntimeException("Error! Out of fuel!");
        }
    }
    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        try {
            while (true) {
                myEngine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel
        }
    }
}


