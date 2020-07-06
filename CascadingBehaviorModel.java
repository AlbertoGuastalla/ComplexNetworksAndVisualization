import java.util.*;

public class CascadingBehaviorModel {
    private static Random rnd = new Random();

    static boolean[] simulateCascadingBehaviorPhenomenon (int s, Map<Integer, List<Integer>> adjacencyMap, int V, double p, double q,
                                                          int maxIterations)
    {
        boolean visited[] = new boolean[V];
        boolean signals[] = new boolean[V];
        Map<Integer, List<Integer>> queue = new HashMap();
        List<Integer> nodesToInsert = new LinkedList<>();
        boolean worldStatus; //true Good false Bad
        boolean signal; //true High false Low
        int iteration = 0, head = s;
        int entryToFill = -1;

        // Genero lo stato del mondo
        worldStatus = rnd.nextDouble() > p;
        System.out.println("Stato del mondo: " + ((worldStatus) ? "Good" : "Bad"));

        signal = generatePrivateSignal(worldStatus, q);
        System.out.println("Nodo sorgente: " + signal);

        signals[s]=signal;
        List<Integer> source = new LinkedList<>();
        source.add(adjacencyMap.get(s).get(0));
        queue.put(s, source);

        for (Integer node : adjacencyMap.keySet()) {
            if (node != s) {
                List<Integer> l = new LinkedList<>();
                queue.put(node, l);
            }
        }

        while (head >= 0 && iteration < maxIterations)
        {
            boolean oldSignal = signals[head];

            int a = 0, b = 0;
            for (Integer adjacent : adjacencyMap.get(head)) {
                if (visited[adjacent]) {
                    if (signals[adjacent]) a++;
                    else b++;
                }
            }

            if (!visited[head])
                signal = generatePrivateSignal(worldStatus, q);

            if (signal) a++;
            else b++;

            if (a > b) signals[head] = true;
            else if (a < b) signals[head] = false;
            else signals[head] = signal;

            visited[head] = true;

            List<Integer> l = adjacencyMap.get(head);
            nodesToInsert.clear();

            for (Integer adjacent : l) {
                if (oldSignal != signals[head]) {
                    nodesToInsert.add(adjacent);
                } else {
                    if (!visited[adjacent]) {
                        nodesToInsert.add(adjacent);
                    }
                }
            }

            if (!nodesToInsert.isEmpty()) {
                if (entryToFill != -1) {
                    queue.get(entryToFill).add(nodesToInsert.get(0));
                    entryToFill = -1;
                }

                if (nodesToInsert.size() >= 2) {
                    queue.get(nodesToInsert.get(0)).add(nodesToInsert.get(1));

                    for (int i = 1; i < nodesToInsert.size() - 1; ++i) {
                        queue.get(nodesToInsert.get(i)).add(nodesToInsert.get(i + 1));
                    }

                    entryToFill = nodesToInsert.get(nodesToInsert.size() - 1);
                } else {
                    entryToFill = nodesToInsert.get(0);
                }
            }

            if (!queue.get(head).isEmpty())
                head = queue.get(head).remove(0);
            else head = -1;

            iteration++;
        }

        System.out.println(iteration);
        return signals;
    }

    static boolean generatePrivateSignal(boolean worldStatus, double q) {
        boolean signal;

        if (worldStatus) {
            if (rnd.nextDouble() <= q)
                signal = true;
            else signal = false;
        } else {
            if (rnd.nextDouble() > q)
                signal = true;
            else signal = false;
        }

        return signal;
    }
}
