class Solution {
    public long findhours(int[] piles, int k){

    long hours = 0;

    for(int i = 0; i < piles.length; i++){
        long hour = (long)Math.ceil((double)piles[i] / k);
        hours += hour;
    }

    return hours;
}
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for(int i=0;i<piles.length;i++){
            high=Math.max(high,piles[i]);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            long hr=findhours(piles,mid);
            if(hr<=h){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}
