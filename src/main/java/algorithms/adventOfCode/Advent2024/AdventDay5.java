package algorithms.adventOfCode.Advent2024;

import algorithms.adventOfCode.AdventOfCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AdventDay5 extends AdventOfCode {

    @Override
    public long getFirstPartSolution() {
        return processUpdates(true);
    }

    @Override
    public long getSecondPartSolution() {
        return processUpdates(false);
    }

    private long processUpdates(boolean onlyValid) {

        List<String> dataFromFile = getInputDataAsListOfString();

        int blankLineIndex = dataFromFile.indexOf("");
        Map<String, Set<String>> rules = parseRules(dataFromFile.subList(0, blankLineIndex));
        List<List<String>> updates = parseUpdates(dataFromFile.subList(blankLineIndex + 1, dataFromFile.size()));

        return updates.stream()
            .filter(update -> {
                boolean valid = isValid(rules, update);
                return onlyValid ? valid: !valid;
            })
            .map(update -> onlyValid ? update : reorderUpdate(rules, update))
            .mapToInt(update -> {
                return Integer.parseInt(update.get(update.size() / 2));
            })
            .sum();

    }


    private List<List<String>> parseUpdates(List<String> updateLines) {
        return updateLines.stream()
            .map(line -> Arrays.asList(line.split(",")))
            .toList();
    }

    private Map<String, Set<String>> parseRules(List<String> ruleLines) {
        Map<String, Set<String>> rules = new HashMap<>();
        for (String rule: ruleLines) {
            String[] parts = rule.split("\\|");
            rules.computeIfAbsent(parts[0], k -> new HashSet<>()).add(parts[1]);
        }
        return rules;
    }

    private boolean isValid(Map<String, Set<String>> rules, List<String> update) {

        Map<String, Integer> pagePositions = buildPagePositions(update);

        for (Map.Entry<String, Set<String>> entry: rules.entrySet()) {

            String beforePage = entry.getKey();
            for (String afterPage: entry.getValue()) {
                if (pagePositions.containsKey(beforePage) && pagePositions.containsKey(afterPage)) {
                    if (pagePositions.get(beforePage) >= pagePositions.get(afterPage))
                        return false;
                }
            }
        }
        return true;
    }

    private Map<String, Integer> buildPagePositions(List<String> update) {
        Map<String, Integer> pagePositions = new HashMap<>();
        for (int i = 0; i < update.size(); i++) {
            pagePositions.put(update.get(i), i);
        }
        return pagePositions;
    }

    private List<String> reorderUpdate(Map<String, Set<String>> rules, List<String> update) {

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();

        for (String page: update) {
            graph.put(page, new ArrayList<>());
            inDegree.put(page, 0);
        }

        for (Map.Entry<String, Set<String>> entry: rules.entrySet()) {
            String beforePage = entry.getKey();
            for (String afterPage: entry.getValue()) {
                if (graph.containsKey(beforePage) && graph.containsKey(afterPage)) {
                    graph.get(beforePage).add(afterPage);
                    inDegree.put(afterPage, inDegree.get(afterPage) + 1);
                }
            }
        }

        Queue<String> queue = new LinkedList<>();
        for (Map.Entry<String, Integer> entry: inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        List<String> sorted = new ArrayList<>();

        while (!queue.isEmpty()) {
            String current = queue.poll();
            sorted.add(current);

            for (String neighbor: graph.get(current)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return sorted;
    }
}
