package graph;

import java.util.*;

public class ConstructItinerary {

        private Map<String, PriorityQueue<String>> map = new HashMap();
        private List<String> res = new ArrayList();

        public List<String> findItinerary(List<List<String>> tickets) {
            // create directed graph
            for (List<String> ticket : tickets) {
                String src = ticket.get(0);
                String dst = ticket.get(1);
                if (!map.containsKey(src)) {
                    PriorityQueue<String> pq = new PriorityQueue();
                    map.put(src, pq);
                }
                map.get(src).add(dst);
            }
            dfs("JFK");
            return res;
        }

        private void dfs(String src) {
            PriorityQueue<String> pq = map.get(src);
            while (pq != null && !pq.isEmpty()) {
                dfs(pq.poll());
            }
            ((ArrayList<String>) res).add(0, src);
        }
}
