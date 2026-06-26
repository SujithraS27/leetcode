class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            while (nums[i] != nums[nums[i] - 1]) {

                int correct = nums[i] - 1;

                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}
