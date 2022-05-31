import java.util.List;
import java.util.Scanner;

import Exceptions.NoPendingReimbursementException;
import model.ReimbursementPojo;
import service.ReimbursementService;
import service.ReimbursementServiceImpl;

public class PresentationLayerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		ReimbursementService reimbursementService = new ReimbursementServiceImpl();
		List<ReimbursementPojo> everyReimbursement;
		char proceed = 'y';

		while (proceed == 'y') {
			System.out.println("*****************************");
			System.out.println("Employee Reimbursment System");
			System.out.println("*****************************");
			System.out.println("1. List all Reimbursements");
			System.out.println("2. Add a new Reimbursement");
			System.out.println("3. View all Pending Reimbursements");
			System.out.println("4. View all Resolved Reimbursements");
			System.out.println("5. Exit");
			System.out.println("*****************************");
			System.out.println("Please enter an option:");
			int option = scan.nextInt();
			System.out.println("*****************************");
			switch (option) {
			case 1:
				
				try {
					everyReimbursement = reimbursementService.viewAllReimbursement();
				} catch (NoPendingReimbursementException e) {
					System.out.println(e.getMessage());
					break;
				} 

			}

		}
	}
}