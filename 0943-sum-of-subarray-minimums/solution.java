class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> st=new Stack<>();
        int pse[]=new int[arr.length];
        int nse[]=new int[arr.length];
        Arrays.fill(pse,-1);
        Arrays.fill(nse,arr.length);
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
                
            }
            if(!st.isEmpty())
                pse[i]=st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                nse[st.pop()]=i;
            }
            st.push(i);
        }
        long result=0;
        for(int i=0;i<arr.length;i++){
            long left=i-pse[i];
            long right=nse[i]-i;
            result=(result+left*right*arr[i])%(1000000000+7);
        }
        return (int)result;
    }
}
