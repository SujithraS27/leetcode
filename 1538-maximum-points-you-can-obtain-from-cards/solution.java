class Solution {
    public int maxScore(int[] cardpoints, int k) {
        int totalsum=0;
        for(int i=0;i<cardpoints.length;i++){
            totalsum=totalsum+cardpoints[i];
        }
        if(k==cardpoints.length){
            return totalsum;
        }
        int sum=0;
        int windowsize=cardpoints.length-k;
         for(int i = 0; i < windowsize; i++){
            sum += cardpoints[i];
        }
        int minsum=sum;
        for(int i=windowsize;i<cardpoints.length;i++){
            sum=sum+cardpoints[i];
            sum=sum-cardpoints[i-windowsize];
            minsum=Math.min(sum,minsum);
        }
        return totalsum-minsum;
    }
}
