package interviews;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Java11Features {
    public static void main(String[] args) throws IOException, InterruptedException {

        var list = List.of("Java", "Spring", "Microservices");
        list.forEach((var item) -> System.out.println(item));

        list.forEach(str -> System.out.println(str));

//        httpClientFeatures();
//        optionalFeatures();
//        stringFeatures();
//        toArrayFeature();
    }

    private static void httpClientFeatures() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        // Adding query parameters
        String baseUrl = "https://jsonplaceholder.typicode.com/posts";
        String params = "?userId=1"; // Example query parameter
        URI uri = URI.create(baseUrl + params);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", "application/json") // Adding a header
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response: " + response.body());
    }

    private static void optionalFeatures() {
        Optional<String> opt = Optional.empty(); // opt.isPresent(); java 8
        System.out.println(opt.isEmpty()); // true
        opt.orElseThrow(); // Throws NoSuchElementException
    }

    private static void stringFeatures() {
        String blank = " ";
        System.out.println(blank.isBlank()); // It will check for blank spaces

        String repeat = "*";
        System.out.println(repeat.repeat(10)); // It will repeat the string 10 times

        String str = "  Java 11  ";
        System.out.println(str.strip()); //removes leading and trailing spaces. like trim()

        String logs = "INFO: Application started\nERROR: Connection failed\nINFO: Request received";
        logs.lines()
                .filter(line -> line.startsWith("ERROR"))
                .forEach(System.out::println);

        String csv = "Alice,24\nBob,30\nCharlie,28";
        csv.lines()
                .map(line -> line.split(","))
                .forEach(data -> System.out.println("Name: " + data[0] + ", Age: " + data[1]));
    }

    private static void toArrayFeature() {
        List<String> sentences = Arrays.asList("Java 8 Stream API",
                "Java 8 Functional Programming feature",
                "Optional feature");

        String[] array = sentences.toArray(String[]::new);
        System.out.println(Arrays.toString(array));
    }
}
