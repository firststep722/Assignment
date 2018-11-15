# Assignment
assignment

This repo contains the abstraction for two different email providers.

If one fails the other service will run.

This is rest api service. The API takes toaddress, cc, bcc, subject and body as request and in return it confirms whether the email is sent or not.
This is handled in such a way that if one service fails, automatically API uses another email service to send an email without the user's knowledge.

This is sample API
http://localhost:8080/RestAPI/rest/customeremail?to=firststep722@gmail.com&cc=abc.xyz@hotmail.com&bcc=abc.pqr@gmail.com&subject=Congratulations&text=this%20is%20simple%20body

It can have multiple recipients(separated by comma)


