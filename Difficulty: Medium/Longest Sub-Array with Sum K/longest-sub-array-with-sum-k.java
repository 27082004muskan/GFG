//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans =
                ob.lenOfLongestSubarr(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int lenOfLongestSubarr(int[] arr, int k) {
       int maxLen =0;
        int sum=0;
        HashMap<Integer,Integer> myMap=new HashMap<>();
        myMap.put(0,-1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            int rem = sum-k;
            if(myMap.containsKey(rem)){
                int len=i-myMap.get(rem);
                maxLen=Math.max(maxLen,len);
            }
            if (!myMap.containsKey(sum)) {
            myMap.put(sum,i);

            }
        }
    return maxLen;
    
       
    }
}
