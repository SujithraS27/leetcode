class Solution {
    public int maximumSum(int[] arr) {
        int delete=0;
        int keep=arr[0];
        int maxsum=arr[0];
        for(int i=1;i<arr.length;i++){
            int prevkeep=keep;
            keep=Math.max(arr[i],prevkeep+arr[i]);
            delete=Math.max(prevkeep,delete+arr[i]);
            maxsum=Math.max(maxsum,Math.max(keep,delete));
        }
        return maxsum;
    }
}