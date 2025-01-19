package algorithms.adventOfCode.Advent2024;

import algorithms.adventOfCode.AdventOfCode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class AdventDay23 extends AdventOfCode {

    @Override
    public long getFirstPartSolution() {
        Map<String, Set<String>> graph = new HashMap<>();
        buildGraph(getInputDataAsListOfString(), graph);
        return countTrianglesStartingWith('t', graph);
    }



    @Override
    public long getSecondPartSolution() {
        return 0;
    }

    private void buildGraph(List<String> input, Map<String, Set<String>> graph) {

        for (String line: input) {
            String[] nodes = line.split("-");
            String nodeA = nodes[0];
            String nodeB = nodes[1];

            graph.computeIfAbsent(nodeA, k -> new HashSet<>()).add(nodeB);
            graph.computeIfAbsent(nodeB, k -> new HashSet<>()).add(nodeA);
        }
    }

    private long countTrianglesStartingWith(char startLetter, Map<String, Set<String>> graph) {

        Set<Set<String>> triangles = new HashSet<>();

        for (String node: graph.keySet()) {
            if (node.charAt(0) == startLetter) {
                Set<String> neighbors = graph.get(node);
                for (String neighborA: neighbors) {
                    for (String neighborB: neighbors) {
                        if (!neighborA.equals(neighborB) && graph.get(neighborA).contains(neighborB)) {
                            Set<String> triangle = new TreeSet<>(Arrays.asList(node, neighborA, neighborB));
                            triangles.add(triangle);
                        }
                    }
                }
            }
        }

        return triangles.size();
    }
}
