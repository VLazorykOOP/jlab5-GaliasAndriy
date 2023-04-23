public class ReactiveEngine extends BaseEngine{
    private String bypassRatio;
    private String thrust;

    public ReactiveEngine() {
        super();
        bypassRatio = "no data";
        thrust = "no data";
    }

    public ReactiveEngine(String type, String bypassRatio, String thrust) {
        super(type);
        this.bypassRatio = bypassRatio;
        this.thrust = thrust;
    }

    public String getBypassRatio() {
        return bypassRatio;
    }
    public void setBypassRatio(String bypassRatio) {
        this.bypassRatio = bypassRatio;
    }

    public String getThrust() {
        return thrust;
    }
    public void setThrust(String thrust) {
        this.thrust = thrust;
    }

    public String show() {
        String res = super.show() + "\n Bypass ratio: " + bypassRatio + "\n Thrust: " + thrust;
        return res;
    }
}