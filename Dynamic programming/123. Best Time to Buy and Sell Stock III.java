class Solution {
    public int maxProfit(int[] prices) {
        int[] firstBuyDp = new int[prices.length];
        int[] secoundBuyDp = new int[prices.length];
        int[] firstSellDp = new int[prices.length];
        int[] secoundSellDp = new int[prices.length];

        Arrays.fill(firstSellDp,-1);
        Arrays.fill(firstBuyDp,-1);
        Arrays.fill(secoundSellDp,-1);
        Arrays.fill(secoundBuyDp,-1);
        return maxProfitFirst(firstBuyDp,secoundBuyDp,firstSellDp,secoundSellDp,0,prices,0);
    }int maxProfitFirst(int[] firstBuyDp,int[] secoundBuyDp,int[] firstSellDp, int[] secoundSellDp,int i,int[] prices,int buyOrSell){
        if(i >= prices.length)return 0;
        if(buyOrSell == 0){
            if(firstBuyDp[i] != -1)return firstBuyDp[i];
            int notBuy  = maxProfitFirst(firstBuyDp,secoundBuyDp,firstSellDp,secoundSellDp,i+1,prices,buyOrSell);
            int buy = maxProfitFirst(firstBuyDp,secoundBuyDp,firstSellDp,secoundSellDp,i+1,prices,1)-prices[i];

            return firstBuyDp[i] = Math.max(notBuy,buy);
        }else{
            if(firstSellDp[i] != -1)return firstSellDp[i];

            int notSell = maxProfitFirst(firstBuyDp,secoundBuyDp,firstSellDp,secoundSellDp,i+1,prices,buyOrSell);
            int sell = prices[i] + maxProfitSecound(secoundBuyDp,secoundSellDp,i+1,prices,0);
            return firstSellDp[i] = Math.max(notSell,sell);
        }
    }static int maxProfitSecound(int[] secoundBuyDp,int[] secoundSellDp,int i,int[] prices,int buyOrSell){
        if(i >= prices.length)return 0;
        if(buyOrSell == 0){
            if(secoundBuyDp[i] != -1)return secoundBuyDp[i];
            int notbuy = maxProfitSecound(secoundBuyDp,secoundSellDp,i+1,prices,buyOrSell);
            int buy = maxProfitSecound(secoundBuyDp,secoundSellDp,i+1,prices,1)-prices[i];

            return secoundBuyDp[i] = Math.max(notbuy,buy);
        }else{
            if(secoundSellDp[i] != -1)return secoundSellDp[i];
            int notSell = maxProfitSecound(secoundBuyDp,secoundSellDp,i+1,prices,buyOrSell);
            int sell = prices[i];

            return secoundSellDp[i] = Math.max(notSell,sell);
        }
    }
}
