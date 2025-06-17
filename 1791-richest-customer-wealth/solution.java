class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxwealth=0;
        for(int row=0;row<accounts.length;row++){
            int wealth=0;
            for(int col=0;col<accounts[row].length;col++){
                wealth=wealth+accounts[row][col];
            }
            if(wealth>=maxwealth){
                maxwealth=wealth;
            }
        }
        return maxwealth;
    }
}
