package assignment;


import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;


public class MailGunExec implements EmailHelper {

/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			String recipient = "firststep722@gmail.com";
			String cc = "";
			String bcc = "";
			String subject = " Testing";
			String text = "Text";
			int status = 0;
			status = sendEmailToCustomer(recipient, cc, bcc, subject, text);
			if (status != 200) {
				status = SendGridExec.secondTry(recipient, cc, bcc, subject, text);
			}
		} catch (UnirestException E) {
			System.out.println(E);
		} catch (IOException IE) {
			System.out.println("IO::" + IE);
		}
	}*/
	

	public int sendEmailToCustomer(String recipient, String cc, String bcc, String subject, String text) 
			 
{
	String status = "";
	int statusCode =0;
	try{
		
		System.out.println("Recepient::" + recipient);
		HttpResponse<String> request = Unirest
				.post("https://api.mailgun.net/v3/sandboxf38b9b3dc12f4e7eb998b2a9907fc3cf.mailgun.org/messages")
				 .basicAuth("api",
				 "c78739c684ec785bac5cbb4afb8a5dd0-9525e19d-be2ea6e2")
				.queryString("from",
						"postmaster@sandboxf38b9b3dc12f4e7eb998b2a9907fc3cf.mailgun.org")
				.queryString("to", recipient)
				.queryString("cc", cc)
				.queryString("bcc", bcc)
				.queryString("subject", subject)
				.queryString("text", text).asString();
				
		System.out.println("Done with request" + request.getStatusText());
		statusCode = request.getStatus();
		status = request.getStatusText();

	}
	catch (UnirestException E) {
		System.out.println(E);
	}catch(Exception IE){
		System.out.println(IE);
	}
	return statusCode;
	}

}
