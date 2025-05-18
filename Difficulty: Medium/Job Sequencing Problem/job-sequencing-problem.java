//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

import java.util.*;

class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // int n = 0;
        // for (int d : deadline) {
        //     n = Math.max(n, d);
        // }

        // int[] assignedJobs = new int[n + 1];
        // Arrays.fill(assignedJobs, -1);

        // int len = profit.length;
        // Integer[] index = new Integer[len];
        // for (int i = 0; i < len; i++) {
        //     index[i] = i;
        // }

        // Arrays.sort(index, (a, b) -> profit[b] - profit[a]);

        // int count = 0;
        // int maxProfit = 0;

        // for (int i = 0; i < len; i++) {
        //     int ind = index[i];
        //     int d = deadline[ind];

        //     while (d > 0 && assignedJobs[d] != -1) {
        //         d--;
        //     }

        //     if (d == 0) continue;

        //     assignedJobs[d] = ind;
        //     count++;
        //     maxProfit += profit[ind];
        // }

        // ArrayList<Integer> res = new ArrayList<>();
        // res.add(count);
        // res.add(maxProfit);
        // return res;
         int n = deadline.length, maxDeadline = 0;
        for (int d : deadline) maxDeadline = Math.max(maxDeadline, d);

        int[] slots = new int[maxDeadline + 1];
        Arrays.fill(slots, -1);

        Integer[] jobs = new Integer[n];
        for (int i = 0; i < n; i++) jobs[i] = i;

        Arrays.sort(jobs, (a, b) -> profit[b] - profit[a]);

        int count = 0, totalProfit = 0;

        for (int i : jobs) {
            for (int d = deadline[i]; d > 0; d--) {
                if (slots[d] == -1) {
                    slots[d] = i;
                    count++;
                    totalProfit += profit[i];
                    break;
                }
            }
        }

        return new ArrayList<>(Arrays.asList(count, totalProfit));
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends