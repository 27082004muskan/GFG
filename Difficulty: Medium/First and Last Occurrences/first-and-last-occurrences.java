// User function Template for Java

class GFG {
    public int First(int arr[] , int x){
        int start =0;
        int end = arr.length-1;
        int ans =-1;
        
        while(start<=end){
            int mid = start +(end-start)/2;
            if(arr[mid]==x){
               ans = mid;
               end=mid-1;
            }else if(arr[mid]<x){
                start=mid+1;
            }else{
                end=mid-1;
            }
            
        }
         return ans;
    }
        public int Last(int arr[] , int x){
        int start =0;
        int end = arr.length-1;
        int ans =-1;
        
        while(start<=end){
            int mid = start +(end-start)/2;
            if(arr[mid]==x){
               ans = mid;
               start=mid+1;
            }else if(arr[mid]<x){
                start=mid+1;
            }else{
                end=mid-1;
            }
           
        }
         return ans;
    }
    
    
    ArrayList<Integer> find(int arr[], int x) {
        // code here
        
        ArrayList<Integer> list = new ArrayList<>();
        int a = First(arr,x);
        int b = Last(arr,x);
        list.add(a);
        list.add(b);
        
        return list;
        
    }
}
