package learnjava;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {
    public static void main(String[] args) {
        Path path = Paths.get("C:/Users/MyDocuments");
        for (Path subPath : path) {  // Iterates over directory components
            System.out.println(subPath);
        }
    }
}

