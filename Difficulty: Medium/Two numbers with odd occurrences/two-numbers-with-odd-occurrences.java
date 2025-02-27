//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    public int[] twoOddNum(int Arr[], int N) {
        int ans = 0;
        
        // XOR of all elements (this will give XOR of the two odd occurring numbers)
        for (int i = 0; i < N; i++) {
            ans ^= Arr[i];
        }

        // Find rightmost set bit (this will differentiate the two numbers)
        int mask = ans & -ans;

        int res[] = new int[2];

        // Divide numbers into two groups and XOR separately
        for (int i = 0; i < N; i++) {
            if ((Arr[i] & mask) == 0) {
                res[0] ^= Arr[i]; // Group 1
            } else {
                res[1] ^= Arr[i]; // Group 2
            }
        }

        // Ensure the larger number comes first
        if (res[0] < res[1]) {
            int temp = res[0];
            res[0] = res[1];
            res[1] = temp;
        }

        return res;
    }
}

