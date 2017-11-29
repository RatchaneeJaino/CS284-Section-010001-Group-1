
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMail {
	public SendMail(String email , String score){
		boolean  ckSendMail = false;
		Date now = new Date();
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
//ScoreStudent sc ;
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("emailtestjava60@gmail.com","0867674544");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("emailtestjava60@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			message.setSubject("Your Score : ");
			message.setText(score);

			Transport.send(message);
				ckSendMail = true;


	                  } catch (MessagingException mex) {
              System.out.println("\n--Exception handling in msgsendsample.java");
              System.out.println(now + " :: ==>> " + mex);

        } catch (Exception e) {
              e.printStackTrace();
        }finally{
              if(ckSendMail){
                    System.out.println("Send E-Mail Success..");
              }else {
                    System.out.println("Send E-Mail Fail..");
              }
              System.out.println("Run Mail Done...");
        }
	}
	
	

}
