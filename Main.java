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

    // return all results weights with no duplicate numbers used unlimited times for
    // each number
    public static ArrayList<ArrayList<Integer>> knapsack(int[] weights, int target) {
        // it is unnecessary if no duplicate numbers or no order required
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

        // pick each number repeatly
        // knapsack(target - weights[index], weights, index, result, results);
        // result.remove(result.size() - 1);
        // knapsack(target, weights, index + 1, result, results);

        // reduce two recursions to one recursion
        for (int i = index; i < weights.length; i++) {
            result.add(weights[i]);

            // don't pick each numbe repeatly
            // knapsack(target - weights[i], weights, i + 1, result, results);

            // pick each number repeatly
            knapsack(target - weights[i], weights, i, result, results);

            result.remove(result.size() - 1);
        }
    }

    // return all results weights contains duplicate numbers
    // and using each number once
    public static ArrayList<ArrayList<Integer>> knapsackII(int[] weights, int target) {
        // sort weights before beginning if weights contains duplicate numbers
        // or sort required
        Arrays.sort(weights);
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<>();
        knapsackII(target, weights, 0, result, results);
        return results;
    }

    private static void knapsackII(int target, int[] weights, int index, ArrayList<Integer> result,
            ArrayList<ArrayList<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(result));
            return;
        }
        if (target < 0 || index >= weights.length) {
            return;
        }

        for (int i = index; i < weights.length; i++) {
            result.add(weights[i]);

            // don't pick each number repeatly
            knapsackII(target - weights[i], weights, i + 1, result, results);
            result.remove(result.size() - 1);

            // avoid returning same result
            while (i < weights.length - 1 && weights[i] == weights[i + 1]) {
                i++;
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] weights = new int[] { 14, 8, 7, 5, 3 };
        int[] weights2 = new int[] { 2, 3, 3, 3, 6, 7 };
        int target = 25;
        int target2 = 9;
        int index = 0;
        // check knapsack true or false
        System.out.println(knapsack(target, weights, index));
        // print knapsack results used unlimited each number times
        // without duplicate numbers
        System.out.println(knapsack(weights, target));
        // print knapsack results used each number once time with duplicate numbers
        System.out.println(knapsackII(weights2, target2));
    }
}
