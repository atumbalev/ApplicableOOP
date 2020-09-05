package streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<String> str = Stream.of("aBc", "d", "ef", "123456").map(String::toUpperCase).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        
        for (String s : str) {
            System.out.println(s);
        }
    }
}