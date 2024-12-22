//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

// class Solution {
//     public int[] getFloorAndCeil(int x, int[] arr) {
//         // code here
//     }
// }

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // Step 1: Sort the array
        Arrays.sort(arr);
        
        int n = arr.length;
        int floor = -1, ceil = -1; // Initialize both to -1 for not found
        
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                // If x is found, it is both floor and ceil
                floor = arr[mid];
                ceil = arr[mid];
                break;
            } else if (arr[mid] < x) {
                // Potential floor
                floor = arr[mid];
                low = mid + 1;
            } else {
                // Potential ceil
                ceil = arr[mid];
                high = mid - 1;
            }
        }

        return new int[] { floor, ceil }; // Return both floor and ceil
    }
}

