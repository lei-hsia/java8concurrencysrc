package citadel;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class UserWhoGetsNoShare {

    /*
     * Complete the 'getUnallottedUsers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY bids
     *  2. INTEGER totalShares
     */

    public static List<Integer> getUnallottedUsers(List<List<Integer>> bids, int totalShares){
        // list to array
        int SIZE = bids.size();
        int[][] bidsArr = new int[SIZE][4];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < 4; j++) {
                bidsArr[i][j] = bids.get(i).get(j);
            }
        }
        // sort: based on bid[2]/price; if equal, sort based on bid[3]/time
        Arrays.sort(bidsArr, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if(a[2]!=b[2]) return b[2]-a[2]; // higher price
                else return a[3]-b[3]; // smaller time
            }
        });

        int remain = totalShares, i = 0; // remain: remaining shares; i: traversal pointer
        List<Integer> res = new ArrayList<>(); // result

        while (i < SIZE-1) {
            if (bidsArr[i][2] > bidsArr[i+1][2]) {
                remain -= bidsArr[i][1];
                i++;
                if (remain <= 0) {
                    for (int j = i+1; j < SIZE; j++) {
                        res.add(bidsArr[j][0]);
                    }
                    return res;
                }
            }
            else if (bidsArr[i][2] == bidsArr[i+1][2]) {
                int blockSize = 2, blockTotalShares = bidsArr[i][3] + bidsArr[i+1][3];
                while (i+blockSize < SIZE && bidsArr[i][2] == bidsArr[i+blockSize][2]) {
                    blockSize++;
                    blockTotalShares += bidsArr[i+blockSize][3];
                }
                if (remain <= blockSize) { // cannot allocate at least 1 for everyone
                    for (int j = i+remain; j < SIZE; j++) {
                        res.add(bidsArr[j][0]);
                    }
                    return res;
                } else if (remain > blockTotalShares) { // fullfill everyone
                    remain -= blockTotalShares;
                    i += blockSize;
                } else { // at least 1 for everyone, but not fullfill
                    for (int j = i+blockSize+1; j < SIZE; j++) {
                        res.add(bidsArr[j][0]);
                    }
                    return res;
                }
            }
        } // i == SIZE-1 && remain!= 0 => at least 1 for last person
        // <=> at least one for everyone
        return res;
    }

}