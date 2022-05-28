CREATE TABLE  manager_details (
    mgr_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY ,
    mgr_firstName VARCHAR (20), mgr_lastName VARCHAR(20),
    mgr_userName VARCHAR(20), mgr_password VARCHAR(20)
);



CREATE TABLE  employee_details (
    emp_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY ,
    mgr_id INT ,
    emp_firstName VARCHAR (255), emp_lastName VARCHAR(255),
    emp_userName VARCHAR(255), emp_password VARCHAR(255),
    FOREIGN KEY (mgr_id) REFERENCES manager_details(mgr_id)
);


CREATE TABLE  reimbursment_details (
    reimbursment_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY ,
    emp_id INT ,mgr_id INT,
    reimbursment_desc VARCHAR (255), reimbursment_amt NUMERIC,
    reimbursment_status VARCHAR (255),
    FOREIGN KEY (emp_id) REFERENCES employee_details(emp_id),
    FOREIGN KEY (mgr_id) REFERENCES manager_details(mgr_id)
);