# Bank Account 

## Overview
  This program models a bank account system with various functionalities, including deposits, withdrawals, and monthly statements.
  It supports two types of accounts: savings accounts and current accounts, each with specific behaviors and attributes.

## Features
### General Account Attributes
- **Balance**: `float`
- **Number of entries**: `int` (initial value = 0)
- **Number of withdrawals**: `int` (initial value = 0)
- **Annual rate (percentage)**: `float`
- **Monthly commission**: `float` (initial value = 0)

## Constructor
The Account class has a constructor that initializes the balance and annual rate attributes with values ​​passed as parameters.

### General Account Methods
1. **Deposit**: Adds money to the balance.
2. **Withdraw**: Deducts money from the balance, ensuring the amount doesn’t exceed the balance.
3. **Calculate Monthly Interest**: Updates the balance based on the monthly interest.
4. **Monthly Statement**: Adjusts the balance by applying the monthly fee and calculates interest.
5. **Print**: Returns the account’s attributes.

### Savings Account
- **Special Attribute**:
  - `isActive`: `boolean` (inactive if balance < 10000, active otherwise)
- **Redefined Methods**:
  1. **Deposit**: Allowed only if the account is active. Inherits base functionality.
  2. **Withdraw**: Allowed only if the account is active. Calls the base method.
  3. **Monthly Statement**: Adds $1000 for each withdrawal beyond 4. Updates activity status based on balance.
  4. **Print**: Returns the balance, monthly commission, and total transactions (sum of deposits and withdrawals).

### Current Account
- **Special Attribute**:
  - `overdraft`: `float` (initial value = 0)
- **Redefined Methods**:
  1. **Withdraw**: Allows overdrawing, updating the overdraft value if balance goes negative.
  2. **Consign**: Inherits base functionality. Reduces overdraft if it exists.
  3. **Monthly Statement**: Inherits base functionality.
  4. **Print**: Returns the balance, monthly fee, total transactions, and overdraft value.

## Requirements
1. **UML Class Diagram**: A clear visual representation of the class hierarchy and relationships.
2. **Unit Tests**: Cover at least 70% of the code.

## Deliverables
1. **GitHub Repository**: Contains all source code and documentation.
2. **Class Diagram**: Screenshot or a public link to a diagram on diagrams.net.
3. **Test Coverage Evidence**: Screenshot of VSCode’s testing section demonstrating coverage.

## Getting Started
1. Clone the repository from GitHub.
2. Set up the environment with your preferred Java IDE.
3. Run the unit tests to ensure functionality.
4. Use the program to create and manage bank accounts.

## Contributing
Feel free to fork the repository and submit pull requests for any improvements or bug fixes.

## License
This project is licensed under the MIT License.

