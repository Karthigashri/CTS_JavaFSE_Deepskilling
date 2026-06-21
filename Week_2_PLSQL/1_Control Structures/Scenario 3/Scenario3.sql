CREATE TABLE Customers_New (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100)
);

CREATE TABLE Loans_New (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    EndDate DATE,
    FOREIGN KEY (CustomerID)
    REFERENCES Customers_New(CustomerID)
);

INSERT INTO Customers_New VALUES (1,'Jothi');
INSERT INTO Customers_New VALUES (2,'Ramesh');
INSERT INTO Customers_New VALUES (3,'Priya');

INSERT INTO Loans_New VALUES (101,1,SYSDATE+15);
INSERT INTO Loans_New VALUES (102,2,SYSDATE+25);
INSERT INTO Loans_New VALUES (103,3,SYSDATE+45);

COMMIT;
SET SERVEROUTPUT ON;

BEGIN
    FOR rec IN (
        SELECT c.Name,
               l.LoanID,
               l.EndDate
        FROM Customers_New c
        JOIN Loans_New l
        ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE
                            AND SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Dear '
            || rec.Name
            || ', Loan '
            || rec.LoanID
            || ' is due on '
            || TO_CHAR(rec.EndDate,'DD-MON-YYYY')
        );
    END LOOP;
END;
/