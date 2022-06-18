class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0,minPricetillNow = prices[0],currProfit=0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]<minPricetillNow)
                minPricetillNow = prices[i];
            currProfit = prices[i]-minPricetillNow;
            maxprofit = Math.max(currProfit,maxprofit);
        }
        
        return maxprofit;
    }
}