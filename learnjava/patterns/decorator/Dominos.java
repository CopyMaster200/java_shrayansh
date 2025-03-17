package learnjava.patterns.decorator;

public class Dominos {
    public static void main(String[] args) {
        String repeater = "#".repeat(50);

        System.out.println(repeater);
        BasePizza margherita = new Margherita();
        BasePizza margheritaExtraCheese = new ExtraCheese(margherita);
        BasePizza margheritaExtraCheeseMushroom = new Mushroom(margheritaExtraCheese);
        System.out.println("Pizza Invoice:");
        System.out.println(repeater);
        System.out.println("Margherita + ExtraCheese + Mushroom: " + margheritaExtraCheeseMushroom.cost());
        System.out.println(repeater);

        // we can also write it like this
        BasePizza margheritaExtraCheeseMushroomOne = new Mushroom(new ExtraCheese(new Margherita()));
        System.out.println("Second way of calling decorator: ");
        System.out.println("Margherita + ExtraCheese + Mushroom: " + margheritaExtraCheeseMushroomOne.cost());
        System.out.println(repeater);

    }
}
