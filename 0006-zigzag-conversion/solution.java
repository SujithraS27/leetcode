class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1 || s.length()<numRows){
            return s;
        }
        StringBuilder[] rows=new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int currrow=0;
        boolean goingdown=true;
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++){
            rows[currrow].append(s.charAt(i));
            if(currrow==0){
                goingdown=true;
            }
            if(currrow==numRows-1){
                goingdown=false;
            }
            if(goingdown){
                currrow++;
            }
            else{
                currrow--;
            }
        }
        for(StringBuilder row:rows){
            ans.append(row);
        }
        return ans.toString();
    }
}
