/**
 * This class creates engines for trains
 */
public class Engine {

    /**
     * fuelType: the fuel type of an engine
     * FuelLevelmax: the maximum level of fuel of an engine
     * FuelLevelcurrent: the current level of fuel of an engine
     */
    private FuelType fuelType;
    public double FuelLevelmax;
    public double FuelLevelcurrent;
    
    /**
     * construct a new engine
     * @param fuelType the fuel type of an engine
     * @param FuelLevelmax the maximum level of fuel of an engine
     */
    public Engine(FuelType fuelType, double FuelLevelmax){
        this.fuelType = fuelType;
        this.FuelLevelmax = FuelLevelmax;
        this.FuelLevelcurrent = this.FuelLevelmax;
    }

    /**
     * gets the type of the fuel
     * @return the type of the fuel
     */
    public FuelType getFuelType(){
        return this.fuelType;
    }

    /**
     * gets the maximum level of fuel
     * @return the maximum level of fuel
     */
    public double getFuelLevelmax(){
        return this.FuelLevelmax;
    }

    /**
     * gets the current level of fuel
     * @return the current level of fuel
     */
    public double getFuelLevelcurrent(){
        return this.FuelLevelcurrent;
    }

    /**
     * refuel the engine to its maximum level
     */
    public void refuel(){
        this.FuelLevelcurrent = this.FuelLevelmax;
    }

    /**
     * decrease the current fuel level and 
     * print the remaining fuel level
     */
    public void go(){
        if (this.FuelLevelcurrent > 0) {
            this.FuelLevelcurrent -= 1;
            System.out.println("Remaining fuel level is:" + getFuelLevelcurrent());
        }
        else { 
            throw new RuntimeException("Error! Out of fuel!");
        }
    }
    
    /**
     * the main() is to test functions in the class
     * @param args
     */
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


