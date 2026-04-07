class Solution {
    public int countDigitOne(int n) {
    if( n < 1) return 0;
    int count = 0;
    long factor = 1;
    while(factor <= n){
        long higher = n/(factor*10);
        long curr = (n / factor)%10;
        long lower = n % factor;
        if(0 == curr){
            count += higher*factor;
        }else if(1 == curr){
            count += higher*factor+lower+1;
        }else{
            count += (higher + 1)* factor;
        }
        factor *= 10;
    }
    return count;
    }
}