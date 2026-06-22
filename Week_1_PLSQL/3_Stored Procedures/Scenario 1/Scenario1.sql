CREATE TABLE Accounts (
    Account_ID NUMBER PRIMARY KEY,
    Customer_ID NUMBER,
    Account_Type VARCHAR2(20),
    Balance NUMBER(10,2)
);
INSERT INTO Accounts VALUES (10, 1, 'SAVINGS', 10000);
INSERT INTO Accounts VALUES (11, 2, 'SAVINGS', 500000);
INSERT INTO Accounts VALUES (12, 3, 'CURRENT', 8000);
COMMIT;
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01
    WHERE Account_Type = 'SAVINGS';

    COMMIT;
END;
/
BEGIN
    ProcessMonthlyInterest;
END;
/
SELECT * FROM Accounts;