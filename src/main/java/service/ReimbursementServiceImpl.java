package service;

import java.util.List;

import Exceptions.NoPendingReimbursementException;
import dao.ReimbursementDao;
import dao.ReimbursementDaoImpl;
import model.ReimbursementPojo;

public class ReimbursementServiceImpl implements ReimbursementService{
	
	ReimbursementDao reimburseDao;
	

	public ReimbursementServiceImpl() {
		reimburseDao = new ReimbursementDaoImpl();
	}

	@Override
	public ReimbursementPojo addReimbursment(ReimbursementPojo reimburse) {
		
		return reimburseDao.addReimbursment(reimburse);
	}

	@Override
	public ReimbursementPojo getReimbursment(int reimbursment_id) {
		// TODO Auto-generated method stub
		return reimburseDao.getReimbursment(reimbursment_id);
	}

	@Override
	public List<ReimbursementPojo> viewAllReimbursement() throws NoPendingReimbursementException {
		// TODO Auto-generated method stub
		return reimburseDao.viewAllReimbursement();
	}

	@Override
	public List<ReimbursementPojo> viewAllPendingRequests() {
		// TODO Auto-generated method stub
		return null;
	}

}
