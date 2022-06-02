import java.util.List;

import io.javalin.Javalin;
import model.ReimbursementPojo;
import service.ReimbursementService;
import service.ReimbursementServiceImpl;

public class ReimbursementCrud {

	public static void main(String[] args) {

		// create an object of service layer to call its methods in each endpoint method
		ReimbursementService reimbursementService = new ReimbursementServiceImpl();
		
		// cors enabled here so that any incoming request from a different domain is accepted
		Javalin server = Javalin.create((config)->config.enableCorsForAllOrigins()); // javalin creates the jetty server (the default ), we can change the internal server if we want to
		server.start(7070); // javlin starts the server at port 7474

		// our first get endpoint
		// can access this endpoint through postman
		
		// will not using this anymore
		// this is just a demo
//		server.get("/hello", (ctx)->{
//			System.out.println("hello endpoint called....");
//			ctx.result("hello returned from the endpoint");
//		});
		
		
		// let's create the other endpoints
		//CRUD
		
		// Read all books
		// we need a get endpoint
		// http://localhost:7474/books
		server.get("/allReimb", (ctx)->{
			// here we contact service, service contacts dao 
			// dao fetches all the books and return it back here
			
			// allBooks contains all the books fetched from the DB
			List<ReimbursementPojo> allRequests = reimbursementService.viewAllReimbursement();
			
			//now put the books in the response body, it has to converted to json format, 
			// the ctx.json() will take care of the above 2 and sends back the response to the client/consumer
			ctx.json(allRequests);
			
		});
		
		// Read a book
		
		// Delete
		
		// Post add book
		// http://localhost:7070/allReimb
		server.post("/allReimb", (ctx)->{
		
			ReimbursementPojo newReimbursement = ctx.bodyAsClass(ReimbursementPojo.class);
			ReimbursementPojo returnedReimbursementPojo = reimbursementService.addReimbursment(newReimbursement);
			
			ctx.json(returnedReimbursementPojo);
			
		});
		
		// Put
	}

}
