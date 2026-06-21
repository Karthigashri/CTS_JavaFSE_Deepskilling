CREATE TABLE Employee (
    Employee_ID NUMBER PRIMARY KEY,
    Employee_Name VARCHAR2(50),
    Department VARCHAR2(30),
    Salary NUMBER(10,2)
);
INSERT INTO Employee VALUES (1,'Shri','IT',50000);
INSERT INTO Employee VALUES (2,'Kumar','IT',60000);
INSERT INTO Employee VALUES (3,'Surekha','HR',45000);
COMMIT;
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus_percent IN NUMBER
)
AS
BEGIN
    UPDATE Employee
    SET Salary = Salary + (Salary * p_bonus_percent / 100)
    WHERE Department = p_department;

    COMMIT;
END;
/

BEGIN
    UpdateEmployeeBonus('IT', 10);
    updateemployeebonus('Manager',20);
END;
/
SELECT * FROM Employee;
