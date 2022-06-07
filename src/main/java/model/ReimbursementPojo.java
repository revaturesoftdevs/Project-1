package model;

import java.util.Objects;

public class ReimbursementPojo {
	
	int reimbursementId;
	int empId;
	int mgrId;
	String reimbursementDesc;
	Double reimbursementAmt;
	String reimbursementStatus;
	


	public ReimbursementPojo() {
		
	}

	
	public ReimbursementPojo(int empId, int mgrId, String reimbursementDesc, Double reimbursementAmt,
			String reimbursementStatus) {
		
		this.empId = empId;
		this.mgrId = mgrId;
		this.reimbursementDesc = reimbursementDesc;
		this.reimbursementAmt = reimbursementAmt;
		this.reimbursementStatus = reimbursementStatus;
	}


	public ReimbursementPojo(int reimbursementId, int empId, int mgrId, String reimbursementDesc,
			Double reimbursementAmt, String reimbursementStatus) {
		
		this.reimbursementId = reimbursementId;
		this.empId = empId;
		this.mgrId = mgrId;
		this.reimbursementDesc = reimbursementDesc;
		this.reimbursementAmt = reimbursementAmt;
		this.reimbursementStatus = reimbursementStatus;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getMgrId() {
		return mgrId;
	}

	public void setMgrId(int mgrId) {
		this.mgrId = mgrId;
	}

	public String getReimbursementDesc() {
		return reimbursementDesc;
	}

	public void setReimbursementDesc(String reimbursementDesc) {
		this.reimbursementDesc = reimbursementDesc;
	}

	public Double getReimbursementAmt() {
		return reimbursementAmt;
	}

	public void setReimbursementAmt(Double reimbursementAmt) {
		this.reimbursementAmt = reimbursementAmt;
	}

	public String getReimbursementStatus() {
		return reimbursementStatus;
	}

	public void setReimbursementStatus(String reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(empId, mgrId, reimbursementAmt, reimbursementDesc, reimbursementId,
				reimbursementStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementPojo other = (ReimbursementPojo) obj;
		return empId == other.empId && mgrId == other.mgrId
				&& Objects.equals(reimbursementAmt, other.reimbursementAmt)
				&& Objects.equals(reimbursementDesc, other.reimbursementDesc)
				&& reimbursementId == other.reimbursementId
				&& Objects.equals(reimbursementStatus, other.reimbursementStatus);
	}

	@Override
	public String toString() {
		return "ReimbursementPojo [reimbursementId=" + reimbursementId + ", empId=" + empId + ", mgrId=" + mgrId
				+ ", reimbursementDesc=" + reimbursementDesc + ", reimbursementAmt=" + reimbursementAmt
				+ ", reimbursementStatus=" + reimbursementStatus + "]";
	}
	
	
	
}
