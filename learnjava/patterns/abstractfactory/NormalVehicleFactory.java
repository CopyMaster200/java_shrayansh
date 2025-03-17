package learnjava.patterns.abstractfactory;

public class NormalVehicleFactory implements VehicleFactory {
    @Override
    public Vehicle getVehicle(String vehicle) {
        return switch (vehicle) {
            case "MARUTHI" -> new Maruthi();
            case "SKODA" -> new Skoda();
            default -> () -> System.out.println("Vehicle not found!");
        };
    }
}
