package devices;
// AbstractDevice.java

public abstract class AbstractDevice implements Device {
    protected int id;
    protected String type;
    protected String status;

    public AbstractDevice(int id, String type) {
        this.id = id;
        this.type = type;
        this.status = "off"; // default status
    }

    public int getId() { return id; }
    public String getType() { return type; }
    public String getStatus() { return status; }

    public void turnOn() {
        status = "on";
        System.out.println(type + " " + id + " turned ON.");
    }

    public void turnOff() {
        status = "off";
        System.out.println(type + " " + id + " turned OFF.");
    }
}
