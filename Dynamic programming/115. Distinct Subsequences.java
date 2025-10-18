class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return distinct(s,0,t,"",dp);
    }int distinct(String s,int pos,String t,String subSequence,int[][] dp){
        if(t.equals(subSequence)){
            return 1;
        }
        if(pos >= s.length())return 0;
        if(dp[pos][subSequence.length()] != -1)return dp[pos][subSequence.length()];
        int notTake = distinct(s,pos+1,t,subSequence,dp);
        int take = 0;
        if(s.charAt(pos) == t.charAt(subSequence.length())){
            take = distinct(s,pos+1,t,subSequence+s.charAt(pos),dp);
        }
        return dp[pos][subSequence.length()] = notTake+take;
    }
}
