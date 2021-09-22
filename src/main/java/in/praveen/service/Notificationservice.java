package in.praveen.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import in.praveen.User;

@Service
public class Notificationservice {
	
	private JavaMailSender javamailsender;
	
	@Autowired
	public Notificationservice(JavaMailSender javamailsender) {
		this.javamailsender=javamailsender;
	}
	
	public void sendNotification(User u) throws MailException {
		
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo(u.getEmail());
		//mail.setFrom("xyzhospital6@gmail.com");
		mail.setCc("xyzhospital6@gmail.com");
		mail.setSubject("Login crediantials for XYX-Hospitals");
		mail.setText("Dear "+u.getName()+",\r\n"
				+ "\r\n"
				+"Your user id:"+u.getEmail()+"\r\n"
				+"\r\n"
				+ "Your temparery password is : " +u.getPassword()+ "\r\n"
				+ "\r\n"
				+"http://localhost:9999/signup");
		javamailsender.send(mail);
	}
	
	public String randompassword() {
		
		       int n=8;
		        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
		                                    + "0123456789"
		                                    + "abcdefghijklmnopqrstuvxyz";
		        StringBuilder sb = new StringBuilder(n);
		        for (int i = 0; i < n; i++)
		        {
		        	int index = (int)(AlphaNumericString.length()* Math.random());
		            sb.append(AlphaNumericString.charAt(index));
		        }
		        return sb.toString();
	}
	
}
