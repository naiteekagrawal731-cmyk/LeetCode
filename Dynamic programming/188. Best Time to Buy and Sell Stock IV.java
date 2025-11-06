class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] dpBuy = new int[prices.length][k];
        int[][] dpSell = new int[prices.length][k];
        for(int[] row : dpSell){
            Arrays.fill(row,-1);
        }
        for(int[] row : dpBuy){
            Arrays.fill(row,-1);
        }
        return stockBuySell(prices,0,0,k,dpBuy,dpSell,0);
    }int stockBuySell(int[] prices,int buyOrSell,int numTrans,int k,int[][] dpBuy,int[][] dpSell,int day){
        if(numTrans == k || day >= prices.length){
            return 0;
        }
        if(buyOrSell == 0){
            if(dpBuy[day][numTrans] != -1)return dpBuy[day][numTrans];
            //Buying
            int notBuy = stockBuySell(prices,buyOrSell,numTrans,k,dpBuy,dpSell,day+1);
            int buy = stockBuySell(prices,1,numTrans,k,dpBuy,dpSell,day+1)-prices[day];

            return dpBuy[day][numTrans] = Math.max(notBuy,buy);
        }else{
            //Selling
            if(dpSell[day][numTrans] != -1)return dpSell[day][numTrans];

            int notSell = stockBuySell(prices,buyOrSell,numTrans,k,dpBuy,dpSell,day+1);
            int sell = prices[day]+stockBuySell(prices,0,numTrans+1,k,dpBuy,dpSell,day+1);

            return dpSell[day][numTrans] = Math.max(notSell,sell);
        }
    }
}
