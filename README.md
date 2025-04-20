This project is written by me as a task to get experience in oop .
In this ,there are ten classes .
Some of them are inherit by others.
This project is start from BankAccount class where basic member or function are included.
Other classes like saving account , checking Account are inherit from bankacount.
Here is a more detailed documentation for the BankApp class:

BankApp Class Documentation

Overview

The BankApp class is a Java-based banking application that provides various services to users, including account creation, login, deposit, withdrawal, and account management.

Class Structure

The BankApp class consists of the following components:

Member Variables
- uniqueAccountNoAssigner: a unique account number assigner
- positionAssignerInVector: a position assigner for the vector
- scanner: a scanner object for user input
- bankAccounts: a vector to store bank account objects

Constructors
- BankApp(): the default constructor that initializes the banking application

Methods
*mainWin()*
- Description: Displays the main window of the banking application.
- Parameters: None
- Returns: None

*showServiceDetail(int accType, int position)*
- Description: Displays the service details for the specified account type and position.
- Parameters:

    - accType: the account type
    - position: the position of the account in the data vector
- Returns: None

*accountType()*
- Description: Displays the account types and returns the selected account type.
- Parameters: None
- Returns: The selected account type

*verifyAccountPresence(String ownerName, int account)*
- Description: Verifies if an account exists with the specified owner name and account number.
- Parameters:

    - ownerName: the owner name
    - account: the account number
- Returns: True if the account exists, false otherwise

*getAccountPositionInData(String ownerName, int account)*
- Description: Returns the position of the account in the data vector.
- Parameters:

    - ownerName: the owner name
    - account: the account number
- Returns: The position of the account in the data vector

*newUser()*
- Description: Creates a new user account and returns the account type.
- Parameters: None
- Returns: The account type

*accountSearchByName(String name)*
- Description: Searches for an account by name and returns the position of the account in the data vector.
- Parameters:

    - name: the account owner name
- Returns: The position of the account in the data vector

Usage Example


public static void main(String[] args) {
    BankApp bankApp = new BankApp();
}
