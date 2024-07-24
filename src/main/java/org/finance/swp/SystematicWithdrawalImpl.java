package org.finance.swp;

public class SystematicWithdrawalImpl implements SystematicWithdrawal {
    InvestmentModel investmentModel;

    public SystematicWithdrawalImpl(InvestmentModel investmentModel) {
        this.investmentModel = investmentModel;
    }

    @Override
    public float totalInvestment() {
        return (float) investmentModel.initialInvestmentValue;
    }

    @Override
    public float totalWithdrawal() {
        int tenure = investmentModel.timePeriod * 12;
        double monthlyWithdrawal = calculateMonthlyWithdrawal();
        return (float) (monthlyWithdrawal * tenure);
    }

    @Override
    public double totalAmountEarned() {
        double initialInvestment = investmentModel.initialInvestmentValue;
        double monthlyWithdrawal = calculateMonthlyWithdrawal();
        double annualRate = investmentModel.annualInterestRate / 100;
        int years = investmentModel.timePeriod;

        double monthlyRate = annualRate / 12;
        int totalMonths = years * 12;

        return calculateCompoundingAmount(initialInvestment, monthlyWithdrawal, monthlyRate, totalMonths);
    }

    @Override
    public double finalRemainingAmount() {
        double initialInvestment = totalInvestment();
        double grossAmount = totalAmountEarned();
        float grossWithdrawal = totalWithdrawal();
        return (grossAmount - grossWithdrawal - initialInvestment);
    }

    double calculateMonthlyWithdrawal() {
        return (investmentModel.userWithdrawalPlan == WithdrawalPlan.ANNUALLY) ? investmentModel.withdrawalValue / 12 : investmentModel.withdrawalValue;
    }

    double calculateCompoundingAmount(double initialInvestment, double monthlyWithdrawal, double rate, int totalMonths) {
        double futureValueFactor = calculateFutureValueFactor(rate, totalMonths);
        double withdrawalFactor = calculateWithdrawalFactor(rate, futureValueFactor);
        double totalInvestmentFactor = initialInvestment * futureValueFactor;
        double withdrawalAmountFactor = monthlyWithdrawal * withdrawalFactor;
        return totalInvestmentFactor - withdrawalAmountFactor;
    }

    // Function to calculate (1 + r)^t
    double calculateFutureValueFactor(double rate, int periods) {
        return Math.pow(1 + rate, periods);
    }

    // Function to calculate the withdrawal factor: (1 + r)^t - 1 / r
    double calculateWithdrawalFactor(double rate, double futureValueFactor) {
        return (futureValueFactor - 1) / rate;
    }
}
