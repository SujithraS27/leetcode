class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums); // sort ascending
        
        int n = nums.length;
        int[] arr = new int[n];
        int left = 0;          // Alice removes first
        int right = 1;         // Bob removes second
        int idx = 0;           // arr insertion index
        
        while (left < n) {
            int alice = nums[left++];
            int bob = nums[left++]; // Bob removes next min
            
            arr[idx++] = bob;       // Bob appends first
            arr[idx++] = alice;     // Alice appends second
        }
        
        return arr;
    }
}
