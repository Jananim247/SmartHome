package factory;

import devices.Device;
import devices.Light;
import devices.Thermostat;
import devices.DoorLock;

public class DeviceFactory {
    public static Device createDevice(String type, int id, int temperature) {
        switch(type.toLowerCase()) {
            case "light": return new Light(id);
            case "thermostat": return new Thermostat(id, temperature);
            case "door": return new DoorLock(id);
            default: throw new IllegalArgumentException("Unknown device type");
        }
    }
}
