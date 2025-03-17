package learnjava;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeDemo {
    public static void main(String[] args) {
        try (FileInputStream fileIn = new FileInputStream("employee.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            Employee emp = (Employee) in.readObject(); // Deserialization
            System.out.println("Name: " + emp.getName() + ", ID: " + emp.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
