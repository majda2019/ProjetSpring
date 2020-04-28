package rc.bootsecurity.controller;

public interface MailService {
public void send(String fromAdress,String toAdress, String subject, String content)throws Exception;
}
