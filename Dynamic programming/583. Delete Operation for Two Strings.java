class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return word1.length()+word2.length()-maxCommonSubsequence(word1,word2,0,0,dp)*2;
    }int maxCommonSubsequence(String word1,String word2,int pos1,int pos2,int[][] dp){
        if(pos1 >= word1.length() || pos2 >= word2.length())return 0;
        if(dp[pos1][pos2] != -1)return dp[pos1][pos2];

        if(word1.charAt(pos1) == word2.charAt(pos2)){
            return dp[pos1][pos2] = 1+maxCommonSubsequence(word1,word2,pos1+1,pos2+1,dp);
        }
        int choice1 = maxCommonSubsequence(word1,word2,pos1+1,pos2,dp);
        int choice2 = maxCommonSubsequence(word1,word2,pos1,pos2+1,dp);

        return dp[pos1][pos2] = Math.max(choice1,choice2);
    }
}
