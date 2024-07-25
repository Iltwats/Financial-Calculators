package org.finance.swp;

public class SWPCalculator {
    public static void main(String[] args) {
        System.out.println("SWP Calculator");
        InvestmentModel investmentModel = new InvestmentModel(
                300000, 2500, 18, 30, WithdrawalPlan.MONTHLY
        );
        SystematicWithdrawal systematicWithdrawal = new SystematicWithdrawalImpl(investmentModel);
        printDetails(systematicWithdrawal);
    }

    private static void printDetails(SystematicWithdrawal systematicWithdrawal) {
        float totalInvestment = systematicWithdrawal.totalInvestment();
        float amountWithdrawn = systematicWithdrawal.totalWithdrawal();
        double amountRemaining = systematicWithdrawal.finalRemainingAmount();

        System.out.printf("Total Investment Amount: Rs. %.0f%n", totalInvestment);
        System.out.printf("Total Withdrawn Amount: Rs. %.0f%n", amountWithdrawn);
        System.out.printf("Total Remaining Amount: Rs. %.0f%n", amountRemaining);
        System.out.printf("Total Amount Earned: Rs. %.0f%n", totalInvestment + amountRemaining);
    }
}
