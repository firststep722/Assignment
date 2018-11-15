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

//@Path ("/customeremail")
public interface EmailHelper {
/*	private String recipient;
	private String cc;
	private String bcc;
	private String subject;
	private String text;*/
	
/*@GET
@Produces(MediaType.TEXT_HTML)*/
	 int sendEmailToCustomer(String recipient,String cc,String bcc, String subject, String text);
			 
}
