public class DieselEngine extends InternalCombustionEngine{
    private String numberOfInjectors;

    public DieselEngine() {
        super();
        numberOfInjectors = "no data";
    }

    public DieselEngine(String type, String fuelType, int cylinderCount, double hp,
                        double torque, double volumeEngine, String numberOfInjectors) {
        super(type, fuelType, cylinderCount, hp, torque, volumeEngine);
        this.numberOfInjectors = numberOfInjectors;
    }

    public String getNumberOfInjectors() {
        return numberOfInjectors;
    }
    public void setNumberOfInjectors(String numberOfInjectors) {
        this.numberOfInjectors = numberOfInjectors;
    }

    public String show() {
        String res = super.show() + "\n Number of injectors: " + numberOfInjectors;
        return res;
    } 
}
