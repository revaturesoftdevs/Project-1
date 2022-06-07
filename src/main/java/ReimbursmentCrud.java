import java.util.List;

import io.javalin.Javalin;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import service.ManagerService;
import service.ManagerServiceImpl;
import model.EmployeePojo;
import model.ManagerPojo;
import model.ReimbursementPojo;

public class ReimbursmentCrud {



	public static void main(String[] args) {

		ManagerService managerService = new ManagerServiceImpl();
		EmployeeService empService= new EmployeeServiceImpl();

		Javalin server = Javalin.create((config) -> config.enableCorsForAllOrigins()); 
		server.start(7474); 
		

		server.post("/loginEmp", (ctx)->{
			EmployeePojo newEmpPojo= ctx.bodyAsClass(EmployeePojo.class);
			EmployeePojo returnEmpPojo= empService.login(newEmpPojo);
			ctx.json(returnEmpPojo);
		});
		

		server.post("/addReimbursement", (ctx) -> {
			ReimbursementPojo newReimbursement = ctx.bodyAsClass(ReimbursementPojo.class);
			boolean returnedReimbursementPojo = empService.addReimbursment(newReimbursement);
			ctx.json(returnedReimbursementPojo);
		});


		server.get("/profile/{eid}",(ctx)->{
			String empId= ctx.pathParam("eid");
			int empIdInteger= Integer.parseInt(empId);
			EmployeePojo empProfile= empService.viewEmployeeProfile(empIdInteger);
			ctx.json(empProfile);
		});


		server.put("/UpdateEmp/{eid}", (ctx) -> {
			EmployeePojo newEmployeePojo = ctx.bodyAsClass(EmployeePojo.class);
			String empId= ctx.pathParam("eid");
			int empIdInteger= Integer.parseInt(empId);
			EmployeePojo returnUpdatedEmployeePojo = empService.modifyEmployee(empIdInteger, newEmployeePojo);
			ctx.json(returnUpdatedEmployeePojo);
		});
		 

		server.get("/EmpPendingReimbursements/{eid}", (ctx) -> {
			String empId= ctx.pathParam("eid");
			int empIdInteger= Integer.parseInt(empId);
			List<ReimbursementPojo> allPendingReimbursments = empService.viewPendingReimbursements(empIdInteger);
			ctx.json(allPendingReimbursments);
		});


		server.get("/EmpResolvedReimbursements/{eid}", (ctx) -> {
			String empId= ctx.pathParam("eid");
			int empIdInteger= Integer.parseInt(empId);
			List<ReimbursementPojo> allResolvedReimbursments = empService.viewResolvedReimbursements(empIdInteger);
			ctx.json(allResolvedReimbursments);
		});

		
		server.post("/loginManager", (ctx) -> {
			ManagerPojo newManagerPojo = ctx.bodyAsClass(ManagerPojo.class);
			System.out.println(newManagerPojo);
			ManagerPojo returnNewManagerPojo = managerService.Login(newManagerPojo);
			ctx.json(returnNewManagerPojo);
		});


		server.get("/ResolvedReimbursements/{mid}", (ctx) -> {
			String mgrId = ctx.pathParam("mid");
			int mgrIdInteger = Integer.parseInt(mgrId);
			List<ReimbursementPojo> allResolvedReimbursments = managerService
					.viewAllResolvedReimbursements(mgrIdInteger);
			ctx.json(allResolvedReimbursments);
		});

		
		server.get("/PendingReimbursements/{mid}", (ctx) -> {
			String mgrId = ctx.pathParam("mid");
			int mgrIdInteger = Integer.parseInt(mgrId);
			List<ReimbursementPojo> allPendingReimbursments = managerService.viewAllPendingReimbursements(mgrIdInteger);
			ctx.json(allPendingReimbursments);
		});

		
		server.get("/IndividualReimbursements/{mid}/{eid}", (ctx) -> {
			String mgrId = ctx.pathParam("mid");
			String empId = ctx.pathParam("eid");
			int mgrIdInteger = Integer.parseInt(mgrId);
			int empIdInteger = Integer.parseInt(empId);
			List<ReimbursementPojo> individualReimbursments = managerService.viewIndividualReimbursement(mgrIdInteger,
					empIdInteger);
			ctx.json(individualReimbursments);
		});

		
		server.get("/AllEmployees/{mid}", (ctx) -> {
			String mgrId = ctx.pathParam("mid");
			int mgrIdInteger = Integer.parseInt(mgrId);
			List<EmployeePojo> allEmployees = managerService.viewAllEmployees(mgrIdInteger);
			ctx.json(allEmployees);
		});

		
		server.put("/approveReimbursement/{eid}/{rid}", (ctx) -> {
			String reimbursementId = ctx.pathParam("rid");
			String empId = ctx.pathParam("eid");
			int reimbIdInteger = Integer.parseInt(reimbursementId);
			int empIdInteger = Integer.parseInt(empId);
			managerService.denyReimbursement(empIdInteger,reimbIdInteger);
		});

		server.put("/denyReimbursement/{eid}/{rid}",(ctx)-> {
			String reimbursementId = ctx.pathParam("rid");
			String emp_id = ctx.pathParam("eid");
			int reimbIdInteger = Integer.parseInt(reimbursementId);
			int empIdInteger = Integer.parseInt(emp_id);
			managerService.denyReimbursement(empIdInteger,reimbIdInteger);
		});

	}
}