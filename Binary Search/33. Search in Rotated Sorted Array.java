class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int middle = left + (right-left)/2;
            int last = nums[nums.length-1];
            if(nums[middle] == target){
                return middle;
            }else if(target == last){
                return nums.length-1;
            }
            else if(target > last){
                if(nums[middle] > target){
                    right = middle-1;
                }else if(nums[middle] >= last && nums[middle] < target){
                    left = middle+1;
                }else if(nums[middle] <= last){
                    right = middle-1;
                }
            }else if(target < last){
                if(nums[middle] < target){
                    left = middle+1;
                }else if(nums[middle] >= last){
                    left = middle+1;
                }else if(nums[middle] < last && nums[middle] > target){
                    right = middle-1;
                }
            }
        }
        return -1;
    }
}
