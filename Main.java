import java.util.*;

public class Main {
    // base case: 1.fill 2.out of bound
    public static boolean knapsack(int target, int[] weights, int index) {
        if (target == 0) {
            return true;
        }
        if (target < 0 || index >= weights.length) {
            return false;
        }
        // pick or not pick item
        return knapsack(target - weights[index], weights, index + 1) || knapsack(target, weights, index + 1);
    }

    public static ArrayList<ArrayList<Integer>> knapsack(int[] weights, int target) {
        // Arrays.sort(weights);
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<>();
        knapsack(target, weights, 0, result, results);
        return results;
    }

    private static void knapsack(int target, int[] weights, int index, ArrayList<Integer> result,
            ArrayList<ArrayList<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(result));
            return;
        }
        if (target < 0 || index >= weights.length) {
            return;
        }

        // result.add(weights[index]);

        // can't pick repeatly the same number
        // knapsack(target - weights[index], weights, index + 1, result, results);
        // pick repeatly the same number
        // knapsack(target - weights[index], weights, index, result, results);

        // result.remove(result.size() - 1);
        // knapsack(target, weights, index + 1, result, results);

        // reduce two recursions to one recursion
        for (int i = index; i < weights.length; i++) {
            result.add(weights[i]);

            // can't pick repeatly the same number
            // knapsack(target - weights[i], weights, i + 1, result, results);

            // pick repeatly the same number
            knapsack(target - weights[i], weights, i, result, results);

            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] weights = new int[] { 14, 8, 7, 5, 3 };
        int target = 25;
        int index = 0;
        System.out.println(knapsack(target, weights, index));
        System.out.println(knapsack(weights, target));
    }
}
