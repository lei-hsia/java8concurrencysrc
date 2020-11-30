package leetcode;

import java.util.*;

public class lc692TopKfreq {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList();
        Map<String, Integer> map = new HashMap();
        for (String w : words) {
            if (!map.containsKey(w)){
                map.put(w,1);
            } else {
                map.put(w, map.get(w)+1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()): a.getValue() - b.getValue()
        );

        // leetcode:1, coding:1, love:2, i:2
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            pq.add(e);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            res.add(0, pq.poll().getKey());
        }

        return res;
    }
}