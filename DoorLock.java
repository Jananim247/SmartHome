package devices;
public class DoorLock extends AbstractDevice {
    public DoorLock(int id) { 
        super(id, "Door"); 
        status = "locked"; 
    }

    @Override
    public void turnOn() {
        status = "unlocked";
        System.out.println("Door " + id + " UNLOCKED.");
    }

    @Override
    public void turnOff() {
        status = "locked";
        System.out.println("Door " + id + " LOCKED.");
    }
}
