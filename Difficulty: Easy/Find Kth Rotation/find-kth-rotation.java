//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }
            Solution ob = new Solution();
            int res = ob.findKRotation(arr);
            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findKRotation(List<Integer> arr) {
        // Code here
        if (arr.size() == 0) {
            return -1;  // Handle edge case (empty array)
        }
        
        int low = 0;
        int high = arr.size() - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Optimization: If the array is already sorted
            if (arr.get(low) < arr.get(high)) {
                if (arr.get(low) < ans) {
                    index = low;
                    ans = arr.get(low);
                }
                break;
            }

            // Left part is sorted
            if (arr.get(low) <= arr.get(mid)) {
                if (arr.get(low) < ans) {
                    index = low;
                    ans = arr.get(low);
                }
                low = mid + 1;
            } else {
                // Right part is sorted
                if (arr.get(mid) < ans) {
                    index = mid;
                    ans = arr.get(mid);
                }
                high = mid - 1;
            }
        }

        return index;
    }
}
