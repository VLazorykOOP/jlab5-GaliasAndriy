public class InternalCombustionEngine extends BaseEngine{
    private String fuelType;
    private int cylinderCount;
    private double hp;
    private double torque;
    private double volumeEngine;

    public InternalCombustionEngine() {
        super();
        fuelType = "no info";
        cylinderCount = 0;
        hp = 0;
        torque = 0;
    }

    public InternalCombustionEngine(String title, String ft,
                                    int cc, double HP, double tor, double ve) {
        super(title);
        fuelType = ft;
        cylinderCount = cc;
        hp = HP;
        torque = tor;
        volumeEngine = ve;
    }

    public String getTitle() {
        return super.getTitle();
    }
    public String getFuelType() {
        return fuelType;
    }
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getCylinderCount() {
        return cylinderCount;
    }
    public void setCylinderCount(int cylinderCount) {
        this.cylinderCount = cylinderCount;
    }
    
    public double getHP() {
        return hp;
    }
    public void setHP(double hp) {
        this.hp = hp;
    }
    
    public double getTorque() {
        return torque;
    }
    public void setTorque(double torque) {
        this.torque = torque;
    }
    
    public double getVolumeEngine() {
        return volumeEngine;
    }
    public void setVolumeEngine(double volumeEngine) {
        this.volumeEngine = volumeEngine;
    }

    public String show() {
        String res = super.show() + "\n Fuel type: " + fuelType + "\n Cylinder count: " + cylinderCount +
        "\n Horse powers: " + hp + "\n Torque: " + torque + " lb-ft stock\n Volume engine: " + volumeEngine;
        return res;
    }
}