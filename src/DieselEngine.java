public class DieselEngine extends InternalCombustionEngine{
    private int numberOfInjectors;

    public DieselEngine() {
        super();
        numberOfInjectors = 0;
    }

    public DieselEngine(String type, String fuelType, int cylinderCount, double hp,
                        double torque, double volumeEngine, int numberOfInjectors) {
        super(type, fuelType, cylinderCount, hp, torque, volumeEngine);
        this.numberOfInjectors = numberOfInjectors;
    }

    public int getNumberOfInjectors() {
        return numberOfInjectors;
    }
    public void setNumberOfInjectors(int numberOfInjectors) {
        this.numberOfInjectors = numberOfInjectors;
    }

    public String show() {
        String res = super.show() + "\n Number of injectors: " + numberOfInjectors;
        return res;
    } 
}
