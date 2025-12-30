import java.util.*;

class Solution {
    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1,
                            List<List<String>> pairs2, double[] rates2) {
        // Build map of reachable currencies with max value from initial on Day 1
        Map<String, Double> day1Map = buildConversionMap(pairs1, rates1, initialCurrency);

        // Build map of reachable currencies with max value from initial on Day 2
        // (values indicate how much of that currency can be obtained from 1 initial unit)
        Map<String, Double> day2Map = buildConversionMap(pairs2, rates2, initialCurrency);

        double maxResult = 0.0;

        // Try each currency as intermediate
        for (Map.Entry<String, Double> entry : day2Map.entrySet()) {
            String currency = entry.getKey();
            double rateDay2 = entry.getValue();

            if (day1Map.containsKey(currency)) {
                // If currency reachable on both days
                double amountAfterDay1 = day1Map.get(currency);
                // Final amount = amountAfterDay1 / rateDay2
                maxResult = Math.max(maxResult, amountAfterDay1 / rateDay2);
            }
        }

        return maxResult;
    }

    private Map<String, Double> buildConversionMap(List<List<String>> pairs, double[] rates,
                                                   String start) {
        Map<String, List<Pair>> graph = new HashMap<>();
        Map<String, Double> conversions = new HashMap<>();

        // Build bidirectional graph
        for (int i = 0; i < pairs.size(); i++) {
            String a = pairs.get(i).get(0);
            String b = pairs.get(i).get(1);
            double rate = rates[i];

            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(new Pair(b, rate));
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(new Pair(a, 1.0 / rate));
        }

        // DFS from start with initial value 1.0
        dfs(graph, conversions, start, 1.0);
        return conversions;
    }

    private void dfs(Map<String, List<Pair>> graph, Map<String, Double> conv,
                     String currency, double currentValue) {
        if (conv.containsKey(currency)) {
            return;
        }

        conv.put(currency, currentValue);

        for (Pair neighbor : graph.getOrDefault(currency, Collections.emptyList())) {
            if (!conv.containsKey(neighbor.curr)) {
                dfs(graph, conv, neighbor.curr, currentValue * neighbor.rate);
            }
        }
    }

    private static class Pair {
        String curr;
        double rate;

        Pair(String c, double r) {
            curr = c;
            rate = r;
        }
    }
}
