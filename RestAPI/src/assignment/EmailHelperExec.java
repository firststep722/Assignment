package assignment;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
@Path ("/customeremail")
public class EmailHelperExec {

		
	@GET
	@Produces(MediaType.TEXT_HTML)
	public  String sendEmail(@QueryParam("to")String recipient, @QueryParam("cc")String cc,@QueryParam("bcc")String bcc, @QueryParam("subject")String subject, @QueryParam("text")String text){
		int statusCode;
		String status ="Email Sent Successfully";
		
		EmailHelper mailGunhelper = new MailGunExec();
		statusCode = mailGunhelper.sendEmailToCustomer(recipient,cc,bcc,subject,text);
		
System.out.println("The status code is : " + statusCode);
		if(statusCode != 200){
			EmailHelper sendGridhelper = new SendGridExec();
			statusCode = sendGridhelper.sendEmailToCustomer(recipient,cc,bcc,subject,text);
			if(statusCode !=202){
				status = "Encountered issue in sending an email";
			}
		}

return status;
		
	}
	
	
	
}
