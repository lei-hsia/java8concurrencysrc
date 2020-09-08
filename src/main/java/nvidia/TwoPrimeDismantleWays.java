package nvidia;

import java.util.Scanner;

public class TwoPrimeDismantleWays {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 2; i <= 100000; i++) {
            if (isPrime(i)) {
                count++;
                System.out.print(i + "\t");
                if (count % 40 == 0) System.out.println();
            }
        }

        System.out.println(count);
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            System.out.println(divideWays(in.nextInt()));
        }
    }

    public static int divideWays(int n) { // 1 <= n <= 100000
        int count = 0;
        for (int i = 2; i < n / 2; i++) {
            if (isPrime(i) && isPrime(n - i)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
