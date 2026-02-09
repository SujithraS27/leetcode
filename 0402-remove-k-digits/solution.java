class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st=new Stack<>();
        int count=k;
        for(int i=0;i<num.length();i++){
            while(!st.isEmpty() && num.charAt(i)<st.peek() && count>0){
                st.pop();
                count=count-1;
            }
            st.push(num.charAt(i));
        }
        while(count>0 && !st.isEmpty()){
            st.pop();
            count=count-1;
        }
        String res="";
        while(!st.isEmpty()){
            res=st.pop()+res;
        }
        res=res.replaceFirst("^0+","");
        if(res.length()==0){
            res="0";
        }
        return res;
    }
}
