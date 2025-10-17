class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int[] res = {-1,-1};
        while (low <= high){
            int middle = (low+high)/2;
            if(nums[middle] < target){
                low = middle+1;
            }else if(nums[middle] > target){
                high = middle-1;
            }else if(nums[middle] == target){
                int low2 = low;
                int high2 = high;
                for(int i = 0;i < nums.length;i++){
                    low2 = middle-i;
                    if(middle-i-1 < 0)break;
                    if(nums[middle-i] != nums[middle-i-1]){
                        break;
                    }
                }
                for(int i = 0;i < nums.length;i++){
                    high2 = middle+i;
                    if(middle+i+1 >= nums.length)break;
                    if(nums[middle+i] != nums[middle+i+1]){
                        break;
                    }
                }
                res[0] = low2;
                res[1] = high2;
                break;
            }
        }
        return res;
    }
}
