class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return path(m-1,n-1,dp,0,0);
    }int path(int m,int n,int[][] dp,int y,int x){
        if(x == n && y == m){
            return 1;
        }if(x > n || y > m){
            return 0;
        }
        if(dp[y][x] != -1)return dp[y][x];
        dp[y][x] = path(m,n,dp,y+1,x)+path(m,n,dp,y,x+1);
        return dp[y][x];
    }
}
