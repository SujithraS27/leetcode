class Solution {

    public int daysNeeded(int[] weights, int capacity) {
        int days = 1;
        int load = 0;

        for (int w : weights) {
            if (load + w <= capacity) {
                load += w;
            } else {
                days++;
                load = w;
            }
        }

        return days;
    }

    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        for (int w : weights) {
            low = Math.max(low, w); // at least the heaviest package
            high += w;              // all packages in one day
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int requiredDays = daysNeeded(weights, mid);

            if (requiredDays <= days) {
                ans = mid;
                high = mid - 1; // try smaller capacity
            } else {
                low = mid + 1;  // need bigger capacity
            }
        }

        return ans;
    }
}
