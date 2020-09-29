class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int maxProfit = -1;
        int maxProfitTime = -1;

        int[] boardingCustomers = new int[4];
        int totalBoardingCustomers = 0;
        int waitedCustomers = 0;

        int time = 0;
        int profit = 0;
        while (time < customers.length || waitedCustomers > 0) {
            if (time != 0) {
                totalBoardingCustomers -= boardingCustomers[time % 4];
                boardingCustomers[time % 4] = 0;
            }

            if (time < customers.length) {
                waitedCustomers += customers[time];
            }

            int temp = Math.min(waitedCustomers, 4);
            waitedCustomers -= temp;
            boardingCustomers[time % 4] = temp;
            totalBoardingCustomers += temp;

            profit += temp * boardingCost - runningCost;
            if (profit > maxProfit) {
                maxProfit = profit;
                maxProfitTime = time + 1;
            }

            time++;
        }

        return maxProfitTime;
    }
}