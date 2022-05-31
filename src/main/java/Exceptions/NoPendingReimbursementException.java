package Exceptions;

public class NoPendingReimbursementException extends Exception {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "You have no pending Reimbursements at this time";
	}
	
	

}
