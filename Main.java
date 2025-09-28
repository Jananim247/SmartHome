import java.util.Scanner;
import java.util.Map;
import devices.Device;
import devices.Thermostat;
import factory.DeviceFactory;
import hub.SmartHomeHub;
import triggers.TemperatureTrigger;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartHomeHub hub = new SmartHomeHub();

        // Initialize devices
        Device light1 = DeviceFactory.createDevice("light", 1, 0);
        Device thermostat = DeviceFactory.createDevice("thermostat", 2, 70);
        Device door = DeviceFactory.createDevice("door", 3, 0);

        hub.addDevice(light1);
        hub.addDevice(thermostat);
        hub.addDevice(door);

        boolean running = true;

        while (running) {
            System.out.println("\n=== Smart Home Menu ===");

            // Display all devices dynamically
            System.out.println("Available Devices:");
            for (Map.Entry<Integer, Device> entry : hub.getDevices().entrySet()) {
                Device d = entry.getValue();
                System.out.println("ID: " + d.getId() + " | Type: " + d.getType() + " | Status: " + d.getStatus());
            }

            System.out.println("\nCommands:");
            System.out.println("1. Turn ON device");
            System.out.println("2. Turn OFF device");
            System.out.println("3. Set schedule");
            System.out.println("4. Set thermostat temperature");
            System.out.println("5. Add temperature trigger");
            System.out.println("6. Show status report");
            System.out.println("0. Exit");

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter device ID to turn ON: ");
                    int onId = scanner.nextInt();
                    hub.turnOn(onId);
                    break;
                case 2:
                    System.out.print("Enter device ID to turn OFF: ");
                    int offId = scanner.nextInt();
                    hub.turnOff(offId);
                    break;
                case 3:
                    System.out.print("Enter device ID for schedule: ");
                    int schedId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter time (HH:MM): ");
                    String time = scanner.nextLine();
                    System.out.print("Enter command (Turn On/Turn Off): ");
                    String command = scanner.nextLine();
                    hub.setSchedule(schedId, time, command);
                    break;
                case 4:
                    System.out.print("Enter thermostat ID: ");
                    int thermoId = scanner.nextInt();
                    System.out.print("Enter new temperature: ");
                    int temp = scanner.nextInt();
                    ((Thermostat) thermostat).setTemperature(temp);
                    hub.notifyTriggers("temperature", temp);
                    break;
                case 5:
                    System.out.print("Enter device ID to trigger on high temperature: ");
                    int deviceId = scanner.nextInt();
                    System.out.print("Enter temperature threshold: ");
                    int threshold = scanner.nextInt();
                    hub.addTrigger(new TemperatureTrigger(">", threshold, light1));
                    System.out.println("Trigger added!");
                    break;
                case 6:
                    hub.statusReport();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting Smart Home System...");
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }

        scanner.close();
    }
}
