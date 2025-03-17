package learnjava;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeDemo {
    public static void main(String[] args) {
        try (FileOutputStream fileOut = new FileOutputStream("employee.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            Employee emp = new Employee(101L, "John");
            out.writeObject(emp); // Serialization
            System.out.println("Serialized data is saved in employee.ser");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}