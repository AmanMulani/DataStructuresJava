package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class AtmCashDispensing {

    //TODO: find a way to print the frequency of the denomination for the minimum number of cash required.

    int[] cashDenomination = {10, 20, 50};

    public int findMinCashRequired(int amount) {
        if(amount <= 0) {
            return 0;
        }

        if(amount % 10 != 0) {
            throw new Error("Invalid amount");
        }

        Integer[] dp = new Integer[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);



        dp[10] = 1;
        for(int i = cashDenomination[0]; i<=amount; i+=10) {
            for(int denomination : cashDenomination) {
                if(denomination <= i) {
                    int res = dp[i-denomination];
                    if(res != Integer.MAX_VALUE && res + 1 < dp[i]) {
                        System.out.println(denomination);
                        dp[i] = res + 1;
                    }
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        return dp[amount];
    }
}
