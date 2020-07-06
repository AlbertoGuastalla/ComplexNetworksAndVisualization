import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SIRModel {
    private static Random rnd = new Random();

    static int[] simulateSIREpidemic (List<Integer> initialInfected, Map<Integer, List<Integer>> adjacencyMap,
                                      int V, double mu_i, double beta, int maxIteration) {
        int iteration = 0;
        boolean stateChanged = true;
        int nodesStatus[] = new int[V]; //0 suscettibili, 1 infetti, 2 rimossi
        List<Integer> newInfected = new LinkedList<>();
        List<Integer> newRemoved = new LinkedList<>();
        List<Integer> taggedNodes = new LinkedList<>();
        int susceptible = V - initialInfected.size();
        int infected = initialInfected.size();
        int removed = 0;

        for (Integer node : initialInfected)
            nodesStatus[node] = 1;

        while (stateChanged && iteration < maxIteration) {
            System.out.println("S: " + susceptible);
            System.out.println("I: " + infected);
            System.out.println("R: " + removed);
            stateChanged = false;

            for (Integer node : adjacencyMap.keySet()) {
                if (nodesStatus[node] == 1) {
                    for (Integer adjacent : adjacencyMap.get(node)) {
                        if (nodesStatus[adjacent] == 0 && !taggedNodes.contains(adjacent)) {
                            if (rnd.nextDouble() <= beta) {
                                //S -> I
                                newInfected.add(adjacent);
                                taggedNodes.add(adjacent);
                                stateChanged = true;
                            }
                        }
                    }

                    if (rnd.nextDouble() <= mu_i) {
                        //I -> R
                        newRemoved.add(node);
                        stateChanged = true;
                    }
                }
            }

            //Aggiorno lo stato dei nodi della rete
            for (Integer node : newInfected) {
                nodesStatus[node] = 1;
            }

            for (Integer node : newRemoved) {
                nodesStatus[node] = 2;
            }

            susceptible -= newInfected.size();
            infected += newInfected.size();
            removed += newRemoved.size();

            newInfected.clear();
            newRemoved.clear();
            taggedNodes.clear();

            iteration++;
        }

        System.out.println(iteration);
        return nodesStatus;
    }
}
