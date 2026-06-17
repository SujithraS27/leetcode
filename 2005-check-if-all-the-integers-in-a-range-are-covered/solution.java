class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {

        int[] diff = new int[52];

        // Mark start and end of each range
        for (int i = 0; i < ranges.length; i++) {

            int start = ranges[i][0];
            int end = ranges[i][1];

            diff[start]++;
            diff[end + 1]--;
        }

        int cover = 0;

        // Build prefix sum and check coverage
        for (int i = 1; i <= 50; i++) {

            cover += diff[i];

            if (i >= left && i <= right && cover == 0) {
                return false;
            }
        }

        return true;
    }
}
