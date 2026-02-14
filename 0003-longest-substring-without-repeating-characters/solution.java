class Solution {
    public int lengthOfLongestSubstring(String s) {
        int lastseenat[]=new int[128];
        Arrays.fill(lastseenat,-1);
        int left=0;
        int maxlength=0;
        for(int right=0;right<s.length();right++){
            int index=s.charAt(right);
            if(lastseenat[index]>=left){
                left=lastseenat[index]+1;
            }
            lastseenat[index]=right;
            maxlength=Math.max(maxlength,right-left+1);
        }
        return maxlength;
    }
}
