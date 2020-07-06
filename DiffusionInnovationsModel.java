import java.util.*;

public class DiffusionInnovationsModel {
    private static Random rnd = new Random();

    static boolean[] simulateDiffusionOfInnovationsPhenomenon (int s, Map<Integer, List<Integer>> adjacencyMap, int V,
                                                               List<Integer> initialAdopters)
    {
        boolean visited[] = new boolean[V];
        boolean nodesFaction[] = new boolean[V];
        double thresholdValues[] = new double[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int iteration = 0;

        queue.add(s);

        for (int i = 0; i < V; ++i)
            thresholdValues[i] = -1.0;

        for (Integer node : initialAdopters)
            nodesFaction[node] = true;

        while (queue.size() > 0)
        {
            s = queue.poll();
            boolean oldFaction = nodesFaction[s];

            //Genero il valore di soglia del nodo s
            if (thresholdValues[s] < 0) thresholdValues[s] = rnd.nextDouble();

            Iterator<Integer> i = adjacencyMap.get(s).listIterator();

            //Calcolo la frazione di nodi che hanno adottato A di s
            int adopters = 0;

            for (Integer adjacent : adjacencyMap.get(s))
                if (nodesFaction[adjacent]) adopters++;

            adopters = adopters / adjacencyMap.get(s).size();

            if (adopters >= thresholdValues[s])
                nodesFaction[s] = true;

            visited[s] = true;

            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n] || oldFaction != nodesFaction[s])
                    queue.add(n);
            }

            iteration++;
        }

        System.out.println(iteration);
        return nodesFaction;
    }
}
