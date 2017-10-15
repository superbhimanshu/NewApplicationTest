package com.test.intTests;

//Suppose we could access yesterday's stock prices as an array, where:
//
//The indices are the time in minutes past trade opening time, which was 9:30am local time.
//The values are the price in dollars of Apple stock at that time.
//So if the stock cost $500 at 10:30am, stockPricesYesterday[60] = 500.
public class MaximumPositiveOrderedDifference {

	public static void main(String[] args) {

		int[] input = { 10, 15, 9, 11, 2, 1 };
		int maxPosDiff = 0;
		int minNegDiff = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = i; j < input.length; j++) {
				if (input[j] - input[i] > maxPosDiff) {
					maxPosDiff = input[j] - input[i];
				}
				if ((input[j] - input[i]) < 0 && input[j] - input[i] > minNegDiff) {

					minNegDiff = input[j] - input[i];
				} else if (input[j] - input[i] < 0) {
					minNegDiff = input[j] - input[i];
				}
			}
		}
		System.out.println("" + maxPosDiff + " " + minNegDiff);
	}

	public int getMaxProfit(int[] stockPricesYesterday) {

		// make sure we have at least 2 prices
		if (stockPricesYesterday.length < 2) {
			throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
		}

		// we'll greedily update minPrice and maxProfit, so we initialize
		// them to the first price and the first possible profit
		int minPrice = stockPricesYesterday[0];
		int maxProfit = stockPricesYesterday[1] - stockPricesYesterday[0];

		// start at the second (index 1) time
		// we can't sell at the first time, since we must buy first,
		// and we can't buy and sell at the same time!
		// if we started at index 0, we'd try to buy /and/ sell at time 0.
		// this would give a profit of 0, which is a problem if our
		// maxProfit is supposed to be /negative/--we'd return 0!
		for (int i = 1; i < stockPricesYesterday.length; i++) {
			int currentPrice = stockPricesYesterday[i];

			// see what our profit would be if we bought at the
			// min price and sold at the current price
			int potentialProfit = currentPrice - minPrice;

			// update maxProfit if we can do better
			maxProfit = Math.max(maxProfit, potentialProfit);

			// update minPrice so it's always
			// the lowest price we've seen so far
			minPrice = Math.min(minPrice, currentPrice);
		}

		return maxProfit;
	}
}
