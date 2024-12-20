# Finance Calculator

## Overview

The Finance Calculator is a Java-based application designed to handle systematic investment and withdrawal plans. It provides functionality to calculate total investments, estimated returns, and withdrawals using different financial strategies. The application is structured to be modular, maintainable, and easily extensible, leveraging several object-oriented design patterns.

## Some Design Patterns Used

### Factory Pattern

The application uses a factory-like approach to manage different investment strategies. Enums such as `InvestmentPlan` and `WithdrawalPlan` define the available strategies, allowing for easy extension and management of different financial plans.

### Strategy Pattern

Interfaces like `SystematicInvestment` and `SystematicWithdrawal` define the contract for different investment and withdrawal strategies. Implementations such as `SystematicInvestmentImpl` and `SystematicWithdrawalImpl` provide specific behaviors, making it easy to switch or add new strategies.

### Template Method Pattern

Methods like `calculateSIPInterest` and `calculateLumpsumInterest` in the `SystematicInvestmentImpl` class follow the template method pattern. This allows for a reusable algorithm structure while enabling specific steps to be overridden in subclasses.


## Getting Started
**Prerequisites**
- Java 18 or higher
- Gradle 8.5 or higher


### Building the Project

To build the project, navigate to the project root directory and run:

```**bash**
./gradlew build
```

### Running the Application

To run the SIP Calculator, execute:
```bash
./gradlew run -PmainClass=org.finance.sip.SIPCalculator
```


To run the SWP Calculator, execute:
```bash
./gradlew run -PmainClass=org.finance.swp.SWPCalculator
```