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
        return calculateInterest(investmentModel.investmentValue, monthlyInterest, totalPayments) - totalInvestment();
    }

    @Override
    public double estimatedReturnsLumpsum() {
        double monthlyInterestRate = investmentModel.annualInterestRate / 12;
        double monthlyInterest = monthlyInterestRate / 100;
        int totalPayments = investmentModel.timePeriod;
        return calculateInterest(investmentModel.investmentValue, monthlyInterest, totalPayments) - totalInvestment();
    }

    double calculateInterest(double investmentValue, double interestRate, int totalPayments) {
        double periodicInterest = 1 + interestRate;
        double compoundingValue = (Math.pow(periodicInterest, totalPayments) - 1) / interestRate;

        return investmentValue * compoundingValue * periodicInterest;
    }

}
