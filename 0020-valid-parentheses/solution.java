class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                st.push(c);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                char last=st.pop();
                if(c==')' && last!='('){
                    return false;
                }
                if(c==']' && last!='['){
                    return false;
                }
                if(c=='}' && last!='{'){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
