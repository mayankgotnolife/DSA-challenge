class Solution {
    public int[] closestPrimes(int left, int right) {
       
        boolean[] prime = new boolean[right +1];
        for(int i= 2 ; i <= right; i++){
            prime[i] = true;
        }

        for(int p=2; p*p <= right; p++){
            if(prime[p]){
                for(int i= p*p; i <=right; i += p){
                    prime[i] = false;
                }
            }
        }

        int num1 = -1;
        int minDiff = Integer.MAX_VALUE;
        int[] result = {-1, -1};

        for(int i = left; i <= right; i++){
            if(prime[i]){
                if(num1 != -1){
                    int diff = i - num1;
                    if(diff < minDiff){
                        minDiff = diff;
                        result[0] = num1;
                        result[1] = i;
                    }
                }
                num1 = i;

            }
        }
        return result;
    }
}