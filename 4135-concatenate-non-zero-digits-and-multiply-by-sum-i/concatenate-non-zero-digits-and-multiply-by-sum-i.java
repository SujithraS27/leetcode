class Solution {
    public long sumAndMultiply(int n) {
        int sum=0;
        int res=0;
        while(n>0){
            int digit=n%10;
            if(digit!=0){
                sum=sum+digit;
                res=res*10+digit;
            }
            n=n/10;
        }
        long rev=0;
        while(res>0){
            int d=res%10;
            rev=rev*10+d;
            res=res/10;
        }
        return rev*sum;
    }
}