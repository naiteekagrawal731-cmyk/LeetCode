class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int left = 1;
        int right = nums[nums.length-1];
        int res = nums[nums.length-1];
        while (left <= right){
            int tes = 0;
            int middle = (left+right)/2;
            for(int i = 0;i < nums.length;i++){
                int chess = nums[i]%middle;
                if(chess > 0){
                    tes += 1;
                }
                tes += nums[i]/middle;
            }
            if(tes > threshold){
                left = middle+1;
                continue;
            }else if(tes <= threshold){
                if(middle < res){
                    res = middle;
                }
                right = middle-1;
            }
            
        }
        return res;
    }
}
