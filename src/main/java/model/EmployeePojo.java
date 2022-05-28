package model;

import java.util.Objects;

public class EmployeePojo {
	
	//testing
	int emp_id; 
	int mgr_id;
	String emp_firstName;
	String emp_lastName;
	String emp_username;
	String emp_password;
	


	public EmployeePojo() {
		super();
	}

	public EmployeePojo(int emp_id, int mgr_id, String emp_firstName, String emp_lastName, String emp_username,
			String emp_password) {
		super();
		this.emp_id = emp_id;
		this.mgr_id = mgr_id;
		this.emp_firstName = emp_firstName;
		this.emp_lastName = emp_lastName;
		this.emp_username = emp_username;
		this.emp_password = emp_password;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public int getMgr_id() {
		return mgr_id;
	}

	public void setMgr_id(int mgr_id) {
		this.mgr_id = mgr_id;
	}

	public String getEmp_firstName() {
		return emp_firstName;
	}

	public void setEmp_firstName(String emp_firstName) {
		this.emp_firstName = emp_firstName;
	}

	public String getEmp_lastName() {
		return emp_lastName;
	}

	public void setEmp_lastName(String emp_lastName) {
		this.emp_lastName = emp_lastName;
	}

	public String getEmp_username() {
		return emp_username;
	}

	public void setEmp_username(String emp_username) {
		this.emp_username = emp_username;
	}

	public String getEmp_password() {
		return emp_password;
	}

	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(emp_firstName, emp_id, emp_lastName, emp_password, emp_username, mgr_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeePojo other = (EmployeePojo) obj;
		return Objects.equals(emp_firstName, other.emp_firstName) && emp_id == other.emp_id
				&& Objects.equals(emp_lastName, other.emp_lastName) && Objects.equals(emp_password, other.emp_password)
				&& Objects.equals(emp_username, other.emp_username) && mgr_id == other.mgr_id;
	}

	@Override
	public String toString() {
		return "EmployeePojo [emp_id=" + emp_id + ", mgr_id=" + mgr_id + ", emp_firstName=" + emp_firstName
				+ ", emp_lastName=" + emp_lastName + ", emp_username=" + emp_username + ", emp_password=" + emp_password
				+ "]";
	}
	
	
	
	
}
