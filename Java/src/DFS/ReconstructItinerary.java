package DFS;

import java.util.*;

/**
 * Created by JMYE on 9/22/16.
 */
public class ReconstructItinerary {


    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        List<String> path = new ArrayList<>();
        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK",flights,path);
        return path;
    }
    private void dfs(String departure, Map<String, PriorityQueue<String>> flights,List<String> path ) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(),flights, path);
        }
        path.add(0,departure);
    }
}
