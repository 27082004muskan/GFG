class Solution {
    static boolean isPrime(int n) {

    if(n <= 1) return false;     // 1 and numbers less than 1 are NOT prime
    if(n == 2) return true;      // 2 IS prime
    
    for(int i = 2; i <= Math.sqrt(n); i++) {  // More efficient! Check up to sqrt(n)
        if(n % i == 0) return false;
    }
    return true;
}

}