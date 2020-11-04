package city;

public class Test {
    public static void main(String[] args) {
        createStr(33);
    }

    public static String createStr(int N) {
        StringBuilder sb = new StringBuilder();
        if (N % 2 == 0) {
            for (int i = 0; i < N - 1; i++) {
                sb.append('a');
            }
            sb.append('b');
        } else {
            for (int i = 0; i < N; i++) {
                sb.append('a');
            }
        }
        return sb.toString();
    }
}
