package shopee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CamelCase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine(); // hello_world  //string.replaceAll("[^a-zA-Z0-9]", "");
        char[] origin = str.toCharArray();
        List<Character> create = new ArrayList<>(origin.length);

        for (int i = 0; i < origin.length; i++) {
            if (!(origin[i]>=48 && origin[i]<=57) || !(origin[i]>=65 && origin[i]<=90) ||
                    !(origin[i]>=97 && origin[i]<=122)) {
                origin[i] = '*';
            }
        }
        // sb: // hello*world
        for (int i = 0; i < origin.length; i++) {
            if (origin[i]=='*') continue;
            create.add(origin[i]);
        }

        for (int i = 0; i < create.size(); i++) {
            System.out.print(create.get(i));
        }
    }
}
