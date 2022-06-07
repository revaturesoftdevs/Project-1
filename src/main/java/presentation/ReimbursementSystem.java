package presentation;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import model.EmployeePojo;
import model.ReimbursementPojo;
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class ReimbursementSystem {

	public static void main(String[] args) {
		
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		
		List<ReimbursementPojo> allResolved; 
		

		allResolved = employeeService.viewResolvedReimbursements(1);

		System.out.println("************************************************");
		allResolved.forEach((item) -> System.out.println(item.getReimbursementId() + "\t" + item.getEmpId() + "\t" + item.getMgrId() + "\t" + item.getReimbursementDesc() + "\t" + item.getReimbursementAmt() + "\t" + item.getReimbursementStatus()));
	}

}
