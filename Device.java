package devices;

public interface Device {
    int getId();
    String getType();
    void turnOn();
    void turnOff();
    String getStatus();
}
