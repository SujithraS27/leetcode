class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        
        // Step 2: Compute gcd of numsDivide
        int g = numsDivide[0];
        for (int i = 1; i < numsDivide.length; i++) {
            g = gcd(g, numsDivide[i]);
        }
        
        // Step 3: Find the smallest number in nums that divides gcd
        for (int i = 0; i < nums.length; i++) {
            if (g % nums[i] == 0) {
                // Elements before i need to be deleted
                return i;
            }
            // No smaller number will work if nums[i] > g
            if (nums[i] > g) break;
        }
        
        // Step 4: No number divides gcd
        return -1;
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
