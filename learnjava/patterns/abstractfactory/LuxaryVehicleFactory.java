package learnjava.patterns.abstractfactory;

public class LuxaryVehicleFactory implements VehicleFactory {
    @Override
    public Vehicle getVehicle(String vehicle) {
        return switch (vehicle) {
            case "BMW" -> new BMW();
            case "MERCEDES" -> new Mercedes();
            default -> () -> System.out.println("Vehicle not found!");
        };
    }
}
