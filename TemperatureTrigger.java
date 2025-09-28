package triggers;

import devices.Device;

public class TemperatureTrigger implements Trigger {
    private int threshold;
    private String condition; // ">" or "<"
    private Device targetDevice;

    public TemperatureTrigger(String condition, int threshold, Device targetDevice) {
        this.condition = condition;
        this.threshold = threshold;
        this.targetDevice = targetDevice;
    }

    @Override
    public void update(String event, int value) {
        if(event.equals("temperature")) {
            boolean conditionMet = condition.equals(">") ? value > threshold : value < threshold;
            if(conditionMet) {
                targetDevice.turnOff();
            }
        }
    }
}