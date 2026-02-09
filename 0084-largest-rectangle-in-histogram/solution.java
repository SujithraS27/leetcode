class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int pse[]=new int[heights.length];
        int nse[]=new int[heights.length];
        Arrays.fill(pse,-1);
        Arrays.fill(nse,heights.length);
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty()){
                pse[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                nse[st.pop()]=i;
            }
            st.push(i);
        }
        int maxarea=0;
        for(int i=0;i<heights.length;i++){
            int area=(nse[i]-pse[i]-1)*heights[i];
            if(area>maxarea){
                maxarea=area;
            }
        }
        return maxarea;
    }
}
