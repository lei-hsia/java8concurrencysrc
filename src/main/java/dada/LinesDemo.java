package dada;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class LinesDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int mode = in.nextInt(), total = in.nextInt();
        int[][] lines = new int[total][2];
        for (int i = 0; i < total; ++i) {
            String str = in.nextLine();
            String[] strings = str.split(",");
            lines[i][0] = Integer.parseInt(strings[0]);
            lines[i][1] = Integer.parseInt(strings[1]);
        }
        int[] bench = new int[2];
        String s = in.nextLine();
        String[] strs = s.split(",");
        bench[0] = Integer.parseInt(strs[0]);
        bench[1] = Integer.parseInt(strs[1]);

        List<int[]> res = new ArrayList<>();
        if (mode == 1) {
             res = contains(lines, bench);
        }else res = overlap(lines, bench);
        for (int[] e : res) {
            System.out.println(e[0]+","+e[1]);
        }
    }

    public static List<int[]> contains(int[][] lines, int[] bench) {
        int n = lines.length;
        int start = bench[0], end = bench[1];
        List<int[]> res = new ArrayList<>();

        for (int[] line : lines) {
            if (line[0] <= start && line[1] >= end) res.add(line);
        }
        return res;
    }

    public static List<int[]> overlap(int[][] lines, int[] bench) {
        int n = lines.length;
        int start = bench[0], end = bench[1];
        List<int[]> res = new ArrayList<>();

        for (int[] line : lines) {
            if (line[1] < start || line[0] > end) continue;
            res.add(line);
        }
        return res;
    }
}