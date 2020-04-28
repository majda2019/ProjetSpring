package rc.bootsecurity.controller;

import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailServiceImp implements MailService{
@Autowired
private JavaMailSender javaMailSender;
@Override
public void send(String fromAdress,String toAdress, String subject, String content) throws Exception {
	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
	mimeMessageHelper.setFrom(fromAdress);
	mimeMessageHelper.setTo(toAdress);
	mimeMessageHelper.setSubject(subject);
	mimeMessageHelper.setText(content,true);
	mimeMessageHelper.setSentDate(new Date());
	javaMailSender.send(mimeMessage);
	
	
	
	
}

}
