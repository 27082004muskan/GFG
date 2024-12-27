//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        // code here
        int n = val.size();
        // Create a list of items with value-to-weight ratio.
        List<double[]> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            items.add(new double[]{val.get(i), wt.get(i), (double) val.get(i) / wt.get(i)});
        }

        // Sort items by value-to-weight ratio in descending order.
        items.sort((a, b) -> Double.compare(b[2], a[2]));

        double totalValue = 0.0;
        for (double[] item : items) {
            if (capacity == 0) break; // Knapsack is full.

            int weight = (int) item[1];
            int value = (int) item[0];

            // Take full or fractional part of the item.
            if (weight <= capacity) {
                totalValue += value;
                capacity -= weight;
            } else {
                totalValue += item[2] * capacity; // Add fractional value.
                capacity = 0;
            }
        }

        return totalValue;
    }
}