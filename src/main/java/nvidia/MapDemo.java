package nvidia;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        Integer b = map.get("b");
        System.out.println(b);
    }
}
