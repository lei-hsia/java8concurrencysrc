package concurrenthashmap;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("a", 1);
        concurrentHashMap.size();

        LongAdder longAdder = new LongAdder();
        longAdder.add(1);

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("b", 1);
    }
}
