package learnjava.patterns.abstractfactory;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        VehicleAbstractFactory abstractFactory = new VehicleAbstractFactory();
        VehicleFactory normalVehicleFactory = abstractFactory.chooseFactory("NORMAL");
        Vehicle skoda = normalVehicleFactory.getVehicle("SKODA");
        skoda.milage();
    }
}
