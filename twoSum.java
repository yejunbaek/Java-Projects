class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] tempNums = new int[nums.length];
        int count = 0;
       for (int i = 0; i < nums.length; i ++) {
        for (int j = 0; j < nums.length; j ++) {
            if (nums[i] + nums[j] == target && i != j) {
                tempNums[count] = i;
                count ++;
            }
        }
       }
        int[] newNums = new int[count];
        for (int i = 0; i < newNums.length; i ++) {
            newNums[i] = tempNums[i];
        }
       return newNums;
    }
}