//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// class Solution {
//     public int getSecondLargest(int[] arr) {
//         // Code Here
        
//          int n =arr.length ;
//         int max=arr[0] ;
//         int SecondMax =arr[0];
//         for(int i=0;i<n;i++){
//             if(arr[i]>=max){
//                 max=arr[i];
//             }
   
            
//         }
//         for(int i =0;i<n;i++){
//             if(arr[i]>=SecondMax && arr[i]!=max){
//                 SecondMax = arr[i];
//             }
//         }
//         return SecondMax ;
       
    
//     }
// }

class Solution {
    public static int getSecondLargest(int[] arr) {
        int n = arr.length;

        // Handle edge cases where second largest cannot be determined
        if (n < 2) {
            return Integer.MIN_VALUE; // Indicate invalid input
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                secondLargest = largest; // Update secondLargest before changing largest
                largest = arr[i]; // Update largest
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i]; // Update secondLargest if greater than current secondLargest
            }
        }

        // If no valid second largest is found (e.g., all elements are the same)
        if (secondLargest == Integer.MIN_VALUE) {
            return -1 ; // Indicate no second largest found
        }

        return secondLargest;
    }
}
