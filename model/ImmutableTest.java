package model;

import java.util.Arrays;

public class ImmutableTest {
    public static void main(String[] args) {
        Order order1 = new Order(1, 10);
        Order order2 = new Order(2, 20);
        Order order3 = new Order(3, 30);

        User user = new User("John", 25, Arrays.asList(order1, order2));

        System.out.println(user);

        user.getOrders().add(order3); // UnsupportedOperationException

        System.out.println(user);
    }
}
