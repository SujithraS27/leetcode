class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int diff[]=new int[n+2];
        for(int i=0;i<bookings.length;i++){
            int start=bookings[i][0];
            int end=bookings[i][1];
            int seats=bookings[i][2];
            diff[start]+=seats;
            diff[end+1]-=seats;
        }
        int prefix=0;
        int answer[]=new int[n];
        for(int i=1;i<=n;i++){
            prefix=prefix+diff[i];
            answer[i-1]=prefix;
        }
        return answer;
    }
}
