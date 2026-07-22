class Solution {
    public boolean checkValidString(String s) {
        int max=0;
        int min=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                max=max+1;
                min=min+1;
            }
            else if(s.charAt(i)==')'){
                max=max-1;
                min=min-1;
            }
            else{
                max=max+1;
                min=min-1;
            }
            if(max<0){
                return false;
            }
            if(min<0){
                min=0;
            }
        }
        return (min==0);
    }
}