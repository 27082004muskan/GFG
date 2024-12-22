//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countFreq(int[] arr, int target) {
        int first = Search(arr, target, true);  // First occurrence
        if (first == -1) {
            return 0; // Target not found
        }
        int last = Search(arr, target, false); // Last occurrence
        return last - first + 1;
    }

    public static int Search(int[] arr, int target, boolean isFirst) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1; // Initialize to -1 to indicate "not found"

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                ans = mid;
                if (isFirst) {
                    high = mid - 1; // Move left for first occurrence
                } else {
                    low = mid + 1; // Move right for last occurrence
                }
            } else if (arr[mid] < target) {
                low = mid + 1; // Move right
            } else {
                high = mid - 1; // Move left
            }
        }
        return ans;
    }
}

    
