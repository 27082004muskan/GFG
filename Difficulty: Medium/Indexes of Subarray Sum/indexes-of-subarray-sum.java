//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static ArrayList<Integer> subarraySum(int[] arr,int k) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1); // Initialize with a default value to indicate no valid subarray
        HashMap<Integer, Integer> myMap = new HashMap<>();
        myMap.put(0, -1); // Handle the case where the subarray starts from index 0
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int rem = sum - k;

            if (myMap.containsKey(rem)) {
                int startingIndex = myMap.get(rem) + 1+1;
                list.set(0, startingIndex); // Update the starting index
                list.add(i+1); // Add the ending index
                break; // Return result immediately
            }
            myMap.put(sum, i);
        }

        return list;
    }
}
