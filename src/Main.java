import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class Main {
    public static void main(String[] args) throws IOException {
//        Trie trie = new Trie();
//        String text = "are they the most fun and these are a fun";
//        Arrays.stream(text.split(" ")).forEach(trie::insert);
//        System.out.println(trie.find("are"));
//        System.out.println(trie.find("and"));
//        System.out.println(trie.find("fun"));
        System.out.println("Map method execution time " + mapMethod());
        System.out.println("Trie method execution time " + trieMethod());

    }

    public static long mapMethod() throws IOException {
        long startTime = System.nanoTime();
        MapAlgorithm mapAlgorithm = new MapAlgorithm();
        File file = new File("/Users/mikhail/engwiki_ascii.txt");
        List<String> lines = Files.readAllLines(file.toPath(), Charset.forName("UTF-8"));
        lines.forEach(line ->
                Arrays.stream(line
                                .replaceAll("[^a-zA-Z]+"," ")
                                .split(" "))
                        .forEach(mapAlgorithm::insert));
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long trieMethod() throws IOException {
        long startTime = System.nanoTime();
        Trie trie = new Trie();
        File file = new File("/Users/mikhail/engwiki_ascii.txt");
        List<String> lines = Files.readAllLines(file.toPath(), Charset.forName("UTF-8"));
        lines.forEach(line ->
                Arrays.stream(line
                                .replaceAll("[^a-zA-Z]+"," ")
                                .split(" "))
                        .forEach(trie::insert));
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}