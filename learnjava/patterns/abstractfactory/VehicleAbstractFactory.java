package learnjava.patterns.abstractfactory;

public class VehicleAbstractFactory {
    public VehicleFactory chooseFactory(String factoryType) {
        return switch (factoryType) {
            case "NORMAL" -> new NormalVehicleFactory();
            case "LUXARY" -> new LuxaryVehicleFactory();
            default -> throw new IllegalArgumentException("Factory not found!");
        };
    }
}
