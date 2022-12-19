import java.util.HashMap;

public class MapAlgorithm {

    private final HashMap<String, Integer> words = new HashMap<>();

    public void insert(String word) {
        words.compute(word, (k, v) -> (v == null) ? 1 : v + 1);
    }

    public Integer find(String word) {
        return words.getOrDefault(word, 0);
    }
}
