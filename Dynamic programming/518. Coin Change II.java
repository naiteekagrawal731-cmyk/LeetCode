class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return change(coins,coins.length-1,dp,amount);
    }int change(int[] coins,int i,int[][] dp,int target){
        if(i ==0){
            if(target%coins[i] == 0){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[i][target] != -1)return dp[i][target];
        int notTake = change(coins,i-1,dp,target);
        int take = Integer.MIN_VALUE;
        if(target-coins[i] >= 0){
            take = change(coins,i,dp,target-coins[i]);
        }
        if(take > 0){
            return dp[i][target] = take + notTake;
        }else {
            return dp[i][target] = notTake;
        }
    }   
}
