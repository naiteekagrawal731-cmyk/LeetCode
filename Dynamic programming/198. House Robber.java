class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];;
        Arrays.fill(dp,-1);
        rob(nums,dp,0);
        rob(nums,dp,1);
        if(dp.length > 1){
            if(dp[1] > dp[0]){
                return dp[1];
            }
        }
        return dp[0];
    }void rob(int[] nums,int[] dp,int i){
        if(i > nums.length-1)return;
        if(i+2 > nums.length-1){
            dp[i] = nums[i];
            return;
        }
        if(dp[i] != -1)return;
        rob(nums,dp,i+2);
        rob(nums,dp,i+3);
        if(i+3 > nums.length-1){
            dp[i] = dp[i+2]+nums[i];
        }else if(dp[i+2] >= dp[i+3]){
            dp[i] = dp[i+2]+nums[i];
        }else if(dp[i+3] > dp[i+2]){
            dp[i] = dp[i+3]+nums[i];
        }
    }
}
