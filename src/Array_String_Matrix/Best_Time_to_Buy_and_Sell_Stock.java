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
}
