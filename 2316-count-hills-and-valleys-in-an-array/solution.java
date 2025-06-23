class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 1; i < n - 1; i++) {
            // Skip if nums[i] == nums[i - 1] (redundant check)
            if (nums[i] == nums[i - 1]) continue;

            // Find previous different value
            int prev = i - 1;
            while (prev >= 0 && nums[prev] == nums[i]) {
                prev--;
            }

            // Find next different value
            int next = i + 1;
            while (next < n && nums[next] == nums[i]) {
                next++;
            }

            // If valid neighbors exist
            if (prev >= 0 && next < n) {
                if (nums[i] > nums[prev] && nums[i] > nums[next]) {
                    count++; // Hill
                } else if (nums[i] < nums[prev] && nums[i] < nums[next]) {
                    count++; // Valley
                }
            }
        }

        return count;
    }
}

