package hub;

import devices.Device;
import proxy.DeviceProxy;
import triggers.Trigger;

import java.util.*;

public class SmartHomeHub {
    private Map<Integer, DeviceProxy> devices = new HashMap<>();
    private List<Trigger> triggers = new ArrayList<>();

    public void addDevice(Device device) {
        devices.put(device.getId(), new DeviceProxy(device));
    }

    public void removeDevice(int id) {
        devices.remove(id);
    }

    public void turnOn(int id) {
        if(devices.containsKey(id)) devices.get(id).turnOn();
        else System.out.println("Device ID " + id + " not found.");
    }

    public void turnOff(int id) {
        if(devices.containsKey(id)) devices.get(id).turnOff();
        else System.out.println("Device ID " + id + " not found.");
    }

    public void setSchedule(int id, String time, String command) {
        System.out.println("Scheduled " + command + " for device " + id + " at " + time);
    }

    public void addTrigger(Trigger trigger) {
        triggers.add(trigger);
    }

    public void notifyTriggers(String event, int value) {
        for(Trigger trigger : triggers) trigger.update(event, value);
    }

    public void statusReport() {
        devices.values().forEach(d -> System.out.println(d.getType() + " " + d.getId() + " is " + d.getStatus()));
    }

    // ✅ Add this getter method to access devices
    public Map<Integer, Device> getDevices() {
        Map<Integer, Device> simpleMap = new HashMap<>();
        for (Map.Entry<Integer, DeviceProxy> entry : devices.entrySet()) {
            simpleMap.put(entry.getKey(), entry.getValue()); // DeviceProxy implements Device
        }
        return simpleMap;
    }
}
