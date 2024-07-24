package org.finance.sip;


public class InvestmentModel {
    double investmentValue;
    float annualInterestRate;
    int timePeriod;
    InvestmentPlan investmentPlan;

    public InvestmentModel(double investmentValue, float annualInterestRate, int timePeriod, InvestmentPlan investmentPlan) {
        this.investmentValue = investmentValue;
        this.annualInterestRate = annualInterestRate;
        this.timePeriod = timePeriod;
        this.investmentPlan = investmentPlan;
    }

    public InvestmentModel setInvestmentValue(double investmentValue) {
        this.investmentValue = investmentValue;
        return this;
    }
}
