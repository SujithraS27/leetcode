class Solution {
    public int arraySign(int[] nums) {
         int negatives = 0;

        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                negatives++;
            }
        }

        if (negatives % 2 == 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
