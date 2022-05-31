package service;

import java.util.List;

import Exceptions.NoPendingReimbursementException;
import model.ReimbursementPojo;

public interface ReimbursementService {
	
ReimbursementPojo addReimbursment(ReimbursementPojo reimburse);
	
	ReimbursementPojo getReimbursment(int reimbursment_id);
	
	List<ReimbursementPojo> viewAllReimbursement()throws NoPendingReimbursementException;
	
	List<ReimbursementPojo> viewAllPendingRequests();
	

}
