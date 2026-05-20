class Solution {
    public boolean increasingTriplet(int[] nums) {

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {

            // smallest number so far
            if (num <= first) {
                first = num;
            }

            // second smallest greater than first
            else if (num <= second) {
                second = num;
            }

            // found third greater than both
            else {
                return true;
            }
        }

        return false;
    }
}
