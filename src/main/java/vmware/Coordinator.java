package vmware;

import java.util.Scanner;

public class Coordinator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), r = in.nextInt();
        while (m != 0) {
            if (n >= r) {
                System.out.printf("%d %d", r, 0);
                m--;
            } else {

            }
        }
    }
}
