package staticvariable;


import java.util.HashMap;

public class StaticTest {
    static HashMap<Integer, String> map2 = new HashMap<>();
    public static void main(String[] args) {
        for (int i = 0; i < 10000000; i++) {
            map2.put(i, "aa"+i);
        }
    }
}
