package org.finance.swp;

public class InvestmentModel {
    double initialInvestmentValue;
    double withdrawalValue;
    float annualInterestRate;
    int timePeriod;
    WithdrawalPlan userWithdrawalPlan;

    public InvestmentModel(double initialInvestmentValue, double withdrawalValue, float annualInterestRate, int timePeriod, WithdrawalPlan withdrawalPlan) {
        this.initialInvestmentValue = initialInvestmentValue;
        this.withdrawalValue = withdrawalValue;
        this.annualInterestRate = annualInterestRate;
        this.timePeriod = timePeriod;
        this.userWithdrawalPlan = withdrawalPlan;
    }
}
