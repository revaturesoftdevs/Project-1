package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Exceptions.NoPendingReimbursementException;
import model.ReimbursementPojo;

public class ReimbursementDaoImpl implements ReimbursementDao{

	@Override
	public ReimbursementPojo addReimbursment(ReimbursementPojo reimburse) {
		try {
			Connection con = DBUtil.makeConnection();
			Statement stmt = con.createStatement();
			
			String query = "INSERT INTO reimbursment_details(emp_id,mgr_id,reimbursment_desc,reimbursment_amt,reimbursment_status)"
							+"VALUES("+reimburse.getEmp_id()+","+reimburse.getMgr_id()+","+reimburse.getReimbursement_amt()+",'"+reimburse.getReimbursement_status()+"')";
			ResultSet rs = stmt.executeQuery(query);
			
			rs.next();
			
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		}
		return reimburse;
	}

	@Override
	public ReimbursementPojo getReimbursment(int reimbursement_id) {
		Statement stmt;
		ReimbursementPojo reimbursePojo = null;
		try {
			Connection conn = DBUtil.makeConnection();
			stmt = conn.createStatement();
			String query = "select * from reimbursment_details where reimbursment_id="+reimbursement_id;
		
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				reimbursePojo = new ReimbursementPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getDouble(5), rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();;
		}
	
		return reimbursePojo;
	}
	

	@Override
	public List<ReimbursementPojo> viewAllReimbursement() throws NoPendingReimbursementException {

		List<ReimbursementPojo> allReimbursements = new ArrayList<ReimbursementPojo>();
		Connection conn = null;
		try {
			// obtain a connection to the db
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM reimbursment_details";
			//the resultSet hold the bunch of records returned by the select query
			ResultSet resultSet = stmt.executeQuery(query);
			int counter = 0;
			// traverse/iterate through the result set
			while(resultSet.next()) {
				counter++;
				// create a reimbursement pojo object and copy the first record's data into it
				ReimbursementPojo reimbursementPojo = new ReimbursementPojo(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getDouble(5),resultSet.getString(6));
				// add the reimbursement pojo object to the collection
				allReimbursements.add(reimbursementPojo);
			}
			if(counter == 0) {
				throw new NoPendingReimbursementException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allReimbursements;
		
		
	}

	@Override
	public List<ReimbursementPojo> viewAllPendingRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimbursementPojo> viewAllResolvedRequests() {
		// TODO Auto-generated method stub
		return null;
	}

}
