class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()+1][p.length()+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int res = wildcard(s,0,p,0,dp);
        if(res == 1)return true;
        return false;
    }int wildcard(String s,int i,String p,int j,int[][] dp){
        if(dp[i][j] != -1)return dp[i][j];
        if(i == s.length() && j == p.length())return 1;
        if(j >= p.length())return dp[i][j] = 0;
        if(i >= s.length() && p.charAt(j) == '*'){
            return dp[i][j] = wildcard(s,i,p,j+1,dp);
        }
        if(i >= s.length())return dp[i][j] = 0;
        if(p.charAt(j) == '*'){
            int notTake = wildcard(s,i,p,j+1,dp);
            int take = wildcard(s,i+1,p,j,dp);
            return dp[i][j] =  Math.max(notTake,take);
        }else if(p.charAt(j) == '?'){
            return dp[i][j] = wildcard(s,i+1,p,j+1,dp);
        }else if(s.charAt(i) == p.charAt(j)){
            return dp[i][j] = wildcard(s,i+1,p,j+1,dp);
        }else{
            return dp[i][j] = 0;
        }
    }
}
