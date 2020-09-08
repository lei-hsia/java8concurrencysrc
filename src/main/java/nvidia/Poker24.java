package nvidia;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Poker24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (str.contains("joker") || str.contains("JOKER")) {
            System.out.println("NONE");
            return;
        }

        String[] strings = str.split(" ");
        Map<String, Integer> count = new HashMap<>();
        for (String s : strings) {
            if (!count.containsKey(s)) count.put(s, 1);
            else count.put(s, count.get(s)+1);
        }
        Map<String, Integer> num = new HashMap<>();
        for (String s : strings) {
            if (s.compareTo("2")>=0 && s.compareTo("10")<=0) num.put(s,Integer.parseInt(s));
            else if (s.equals("J")) num.put(s, 11);
            else if (s.equals("Q")) num.put(s, 12);
            else if (s.equals("K")) num.put(s, 13);
            else if (s.equals("A")) num.put(s, 1);
        }
        // map: {1,1},{2,1},{3,1},{4,1}

    }
}
