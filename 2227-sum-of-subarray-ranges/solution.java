class Solution {
    public long subArrayRanges(int[] nums) {
        long min=submin(nums);
        long max=submax(nums);
        return (max-min);
    }
    public long submin(int[] nums){
        Stack<Integer> st=new Stack<>();
        int pse[]=new int[nums.length];
        int nse[]=new int[nums.length];
        Arrays.fill(pse,-1);
        Arrays.fill(nse,nums.length);
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[i]<=nums[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                pse[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[i]<=nums[st.peek()]){
                nse[st.pop()]=i;
            }
            st.push(i);
        }
        long result=0;
        for(int i=0;i<nums.length;i++){
            long left=i-pse[i];
            long right=nse[i]-i;
            result=(result+left*right*nums[i]);
        }
        return result;
    }
    public long submax(int[] nums){
        Stack<Integer> st=new Stack<>();
        int pge[]=new int[nums.length];
        int nge[]=new int[nums.length];
        Arrays.fill(pge,-1);
        Arrays.fill(nge,nums.length);
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[i]>=nums[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                pge[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[i]>=nums[st.peek()]){
                nge[st.pop()]=i;
            }
            st.push(i);
        }
        long result=0;
        for(int i=0;i<nums.length;i++){
            long left=i-pge[i];
            long right=nge[i]-i;
            result=(result+left*right*nums[i]);
        }
        return result;
    }
}
