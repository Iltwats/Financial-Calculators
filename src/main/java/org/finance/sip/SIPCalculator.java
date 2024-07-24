package org.finance.sip;

public class SIPCalculator {
    public static void main(String[] args) {
        InvestmentModel investmentModel = new InvestmentModel(10000, 15, 10, InvestmentPlan.LUMPSUM);
        SystematicInvestment systematicInvestment = new SystematicInvestmentImpl(investmentModel);
        printDetails(systematicInvestment, investmentModel);
    }

    private static void printDetails(SystematicInvestment systematicInvestment, InvestmentModel investmentModel) {
        double totalMoney = systematicInvestment.totalInvestment();
        System.out.printf("Total Invested Amount: Rs. %.0f%n", systematicInvestment.totalInvestment());
        if (investmentModel.investmentPlan == InvestmentPlan.LUMPSUM) {
            System.out.printf("Estimated Returns: Rs. %.0f%n", systematicInvestment.estimatedReturnsLumpsum());
            totalMoney += systematicInvestment.estimatedReturnsLumpsum();
        } else {
            System.out.printf("Estimated Returns: Rs. %.0f%n", systematicInvestment.estimatedReturnsMonthly());
            totalMoney += systematicInvestment.estimatedReturnsMonthly();
        }

        System.out.printf("Total Value: Rs. %.0f%n", totalMoney);
    }
}
