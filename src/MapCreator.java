import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapCreator {
    public Map<String, Integer> creating(){
        Map<String, Integer> hashmap = new HashMap<>();
        hashmap.put("One", (int) ((Math.random() + 1) * 100));
        hashmap.put("Two", (int) ((Math.random() + 1) * 100));
        hashmap.put("Three", (int) ((Math.random() + 1) * 100));
        hashmap.put("Four", (int) ((Math.random() + 1) * 100));
        hashmap.put("Five", (int) ((Math.random() + 1) * 100));
        hashmap.put("Six", (int) ((Math.random() + 1) * 100));
        hashmap.put("Seven", (int) ((Math.random() + 1) * 100));
        return hashmap;
    }
}
