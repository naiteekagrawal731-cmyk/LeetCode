class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return commonSubsequence(text1,text2,dp,0,0);
    }int commonSubsequence(String text1,String text2,int[][] dp,int i,int j){
        if(i >= text1.length() || j >= text2.length())return 0;
        if(dp[i][j] != -1)return dp[i][j];
        if(text1.charAt(i) == text2.charAt(j)){
            return dp[i][j] = 1 + commonSubsequence(text1,text2,dp,i+1,j+1);
        }else{
            return dp[i][j] = Math.max(commonSubsequence(text1,text2,dp,i+1,j),commonSubsequence(text1,text2,dp,i,j+1));
        }
    }
}
