package org.finance.sip;

public class SystematicInvestmentImpl implements SystematicInvestment {
    InvestmentModel investmentModel;

    public SystematicInvestmentImpl(InvestmentModel investmentModel) {
        this.investmentModel = investmentModel;
    }

    @Override
    public double totalInvestment() {
        if (investmentModel.investmentPlan == InvestmentPlan.LUMPSUM) return investmentModel.investmentValue;
        else return investmentModel.investmentValue * investmentModel.timePeriod * 12;
    }

    @Override
    public double estimatedReturnsMonthly() {
        double monthlyInterestRate = investmentModel.annualInterestRate / 12;
        double monthlyInterest = monthlyInterestRate / 100;
        int totalPayments = investmentModel.timePeriod * 12;
        return calculateSIPInterest(investmentModel.investmentValue, monthlyInterest, totalPayments) - totalInvestment();
    }

    @Override
    public double estimatedReturnsLumpsum() {
        double annualRate = investmentModel.annualInterestRate  / 100;
        return calculateLumpsumInterest(investmentModel.investmentValue, annualRate, investmentModel.timePeriod) - totalInvestment();
    }

    double calculateSIPInterest(double principal, double interestRate, int totalPayments) {
        double periodicInterest = 1 + interestRate;
        double compoundingValue = (Math.pow(periodicInterest, totalPayments) - 1) / interestRate;
        return principal * compoundingValue * periodicInterest;
    }

    double calculateLumpsumInterest(double principal, double rate, int years) {
        return principal * Math.pow(1 + (rate / 12), 12 * years);
    }

}
