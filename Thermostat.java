package devices;
public class Thermostat extends AbstractDevice {
    private int temperature;

    public Thermostat(int id, int temperature) {
        super(id, "Thermostat");
        this.temperature = temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Thermostat " + id + " set to " + temperature + "°F.");
    }

    public int getTemperature() { return temperature; }
}