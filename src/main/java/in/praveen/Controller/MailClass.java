package in.praveen.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.praveen.User;
import in.praveen.service.Notificationservice;

@RestController
public class MailClass {
	
	@Autowired
	private Notificationservice ns;
	
	@RequestMapping("/hello")
	public String SendMails() {
		return "welcome to java mailsender";
	}
	
	@RequestMapping("/signup")
	public String mailsent() {
		System.out.println("calling");
		User u=new User();
		u.setEmail("natanipraveenkumar@gmail.com");
		u.setName("praveen");
		u.setPassword(ns.randompassword());
		try {
			ns.sendNotification(u);
		}catch(MailException e) {
			//catch error
			
		}
		return "Email="+u.getEmail()+"\n Name="+u.getName()+"\n Password="+u.getPassword();
	}
}
