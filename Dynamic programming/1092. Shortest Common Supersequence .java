class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        commonSubSequence(str1,str2,0,0,dp);
        StringBuilder res = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < str1.length() && j < str2.length()){
            if(str1.charAt(i) == str2.charAt(j)){
                res.append(str1.charAt(i));
                i++;
                j++;
            }else if(dp[i+1][j] >= dp[i][j+1]){
                res.append(str1.charAt(i));
                i++;
            }else{
                res.append(str2.charAt(j));
                j++;
            }
        }
        while (i < str1.length()){
            res.append(str1.charAt(i));
            i++;
        }
        while (j < str2.length()){
            res.append(str2.charAt(j));
            j++;
        }
        return new String(res);
    }int commonSubSequence(String s1,String s2,int i,int j,int[][] dp){
        if(i >= s1.length() || j >= s2.length())return dp[i][j] =  0;
        if(dp[i][j] != -1)return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1+commonSubSequence(s1,s2,i+1,j+1,dp);
        }
        int choice1 = commonSubSequence(s1,s2,i+1,j,dp);
        int choice2 = commonSubSequence(s1,s2,i,j+1,dp);
        if(choice1 >= choice2){
            return dp[i][j] = choice1;
        }else{
            return dp[i][j] = choice2;
        }
    }
}
