# Invoicing

## 1 Cycle
### EBFR011 Login

* Primary Actor: Accountant
* Preconditions: Accountant has an account (registered email and password) in the 
system. 
* Postconditions: Accountant logins and is the “Main menu” window.
* Main Success Scenario:
1. System shows a “Sign in” window that requires to input email.
2. Accountant enters the correct email and press "Enter" key.
3. System shows a “Sign in” window that requires to input password.
4. Accountant enters the correct password and press "Enter" key.
5. System opens the “Main menu” window.
* Alternative Scenario:
4. Accountant enters an incorrect email or password and press "Enter" key.
5. The System gets back to the “Sign in” window and presents the message which tells 
about email or password incorrectness.

## 2 Cycle
### EBFR020 View Clients
* Primary Actor: Accountant
* Preconditions: Accountant is logged in the system and is in the “Main Menu” window 
that has “Clients” option.
* Postconditions: Clients and their main information are displayed to the user.
* Main Success Scenario:
1. Accountant chooses the “Clients” option.
2. System opens the “Clients” window with text on how many clients are added and 
also all clients listed in the table. Each client's main information is presented next 
to his credentials: email, organization, invoiced amount, received amount from 
payments.

### EBFR021 Add Client
* Primary Actor: Accountant
* Preconditions: Accountant is logged in the system and is in the “Clients” window that 
has a “New Client” option.
* Postconditions: New client is added to the system and the “Clients” window shows 
one more client.
* Main Success Scenario:
1. Accountant chooses the “New Client” option.
2. System opens the “New Client” window with various 
inputs: Organization name, First name, Last name, Email;
3. Accountant fills all required fields and presses the "Enter" key.
4. System opens the “Clients” window and prints a message that a client was added.
* Alternative Scenario:
3. Accountant fills not all required fields and presses the “Enter” key.
4. System stays in “New Client” window and prints a message which of the required 
parameter is not filled.


