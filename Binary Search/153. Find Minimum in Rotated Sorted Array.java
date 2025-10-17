class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums[0] < nums[nums.length-1]){
            return nums[0];
        }
        if(nums.length == 1){
            return nums[0];
        }
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int middle = left + (right-left)/2;
            if(middle-1 >= 0 && nums[middle] < nums[middle-1]){
                return nums[middle];
            }
            if(nums[middle] < nums[0]){
                right = middle-1;
            }else if(nums[middle] >= nums[0]){
                left = middle+1;
            }
        }
        return 0;
    }
}
