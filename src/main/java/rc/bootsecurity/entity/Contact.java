package rc.bootsecurity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="contact")
public class Contact {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		@Column(name="name")
		private String name;
		
		@Column(name="phone")
		private String phone;
		
		@Column(name="email")
		private String email;
		@Column(name="adress")
		private String adress;
		@Column(name="subject")
		private String subject;
		@Column(name="content")
		private String content;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAdress() {
	return adress;
}
public void setAdress(String adress) {
	this.adress = adress;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Contact(String name, String phone, String email, String adress, String subject, String content) {
	super();
	this.name = name;
	this.phone = phone;
	this.email = email;
	this.adress = adress;
	this.subject = subject;
	this.content = content;
}
public Contact() {
	super();
	// TODO Auto-generated constructor stub
}

}
