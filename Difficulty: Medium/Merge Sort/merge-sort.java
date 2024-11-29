//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            new Solution().mergeSort(arr, 0, arr.length - 1);

            for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    void mergeSort(int arr[], int l, int r) {
        // code here
        if(l>=r){
            return ;
        }
        int mid=l+(r-l)/2;
        mergeSort(arr, l , mid);
        mergeSort(arr, mid+1, r);
        conquer(arr, l , mid , r);
        
    }
    void conquer(int arr[] , int l , int mid , int r){
        int merged[]=new int[r-l+1];
        int index1=l , index2=mid+1, x=0; 
        while(index1<=mid && index2<=r){
            if(arr[index1]<=arr[index2]){
                merged[x++]=arr[index1++];
            }else{
                merged[x++]=arr[index2++];
            }
        }
        while(index1<=mid){
            merged[x++]=arr[index1++];
        }
        while(index2<=r){
            merged[x++]=arr[index2++];
        }
    for (int i = 0; i < merged.length; i++) {
            arr[l + i] = merged[i];
        }
    }
}
