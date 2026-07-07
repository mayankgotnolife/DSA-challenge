class Solution {
    public long sumAndMultiply(int n) {
       long sum =0, x= 0, p =1;
       while(n > 0){
        int d = n % 10;

        if(d != 0) {
        x = d *p +x;
        p *= 10;
        sum += d;
        }
        n/= 10;
       }
       
       return sum * x;
    }
}