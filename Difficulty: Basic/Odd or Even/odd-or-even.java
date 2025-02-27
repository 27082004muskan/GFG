//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isEven(N))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    static boolean isSet(int n , int bit){
        int res = n & (1<<bit);
        return (res==0)?false:true;
    }
    static boolean isEven(int n) {
        // code here

        if(isSet(n,0)){
    return false ;
}
return true;
    }
    
}