package assignment;

import com.sendgrid.*;

import java.io.IOException;

public class SendGridExec implements EmailHelper{
	public  int sendEmailToCustomer(String recipient,String cc, String bcc, String subject,String text)  {
		Response response;
		String status = "Encountered issue";
		int statusCode = 0;
		try {
			  Email fromAddress = new Email("test@example.com");
			  Email toAddress = new Email(recipient);
			    Content content = new Content("text/plain", text);
			    Mail mail = new Mail(fromAddress, subject, toAddress, content);
			SendGrid sendGridObject = new SendGrid("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");
			System.out.println("tryingsendgrid.." +new SendGrid("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"));
			Request request = new Request();
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			response = sendGridObject.api(request);
			System.out.println(response.getBody());
			System.out.println(response.getStatusCode());
			System.out.println(response.getHeaders());
/*			if(response.getStatusCode() == 202){
				status = "Email sent successfully";
			}*/
			statusCode = response.getStatusCode();
		} catch (IOException ex) {
			System.out.println(ex);
		}
		return statusCode;
	}
}