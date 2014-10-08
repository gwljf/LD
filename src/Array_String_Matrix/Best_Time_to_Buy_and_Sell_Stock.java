package Array_String_Matrix;

/**
 * Created by wlf on 10/7/14.
 */
public class Best_Time_to_Buy_and_Sell_Stock {
/*
    Say you have an array for which the ith element is the price of a given stock on day i.

    If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int lowest = prices[0];
        int max = 0;
        for(int i=1; i<prices.length; ++i){
            lowest = Math.min(lowest, prices[i]);
            max = Math.max(max, prices[i]-lowest);
        }
        return max;
    }


/*
    Say you have an array for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
    public int maxProfit2(int[] prices) {
        if(prices.length==0 || prices.length==1){
            return 0;
        }
        int min = prices[0];
        int total = 0;
        for(int i=1; i<prices.length; ++i){
            if(prices[i]<prices[i-1]){              // 找到下降沿
                total += prices[i-1]-min;
                min = prices[i];
            }
        }
        if(prices[prices.length-1]>min){            // 注意最后一个
            total += prices[prices.length-1]-min;
        }
        return total;
    }

/*
    Say you have an array for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete at most two transactions.

            Note:
    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
    public int maxProfit3(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        int len = prices.length;
        int[] left = new int[len];
        int[] right = new int[len];

        left[0]=0;
        int min = prices[0];
        int profit = 0;
        for(int i=1; i<len; ++i){
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i]-min);
            left[i] = profit;
        }

        int max = prices[len-1];
        profit = 0;
        for(int i=len-2; i>=0; --i){
            max = Math.max(max, prices[i]);
            profit = Math.max(profit, max-prices[i]);
            right[i] = profit;
        }

        int total = 0;
        for(int i=0; i<len; ++i){
            total = Math.max(total, left[i]+right[i]);
        }
        return total;
    }
}
