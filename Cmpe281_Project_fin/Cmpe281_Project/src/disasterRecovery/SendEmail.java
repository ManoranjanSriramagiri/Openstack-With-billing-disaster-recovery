package disasterRecovery;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendEmail extends Object{

public static void main(String [] args)
{

    try{

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // for yahoo use smtp.mail.yahoo.com
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true"); 
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("cmpe273projecttest@gmail.com", "cmpe@273");
            }
        });

        mailSession.setDebug(true);

        Message msg = new MimeMessage( mailSession );

        //--[ Set the FROM, TO, DATE and SUBJECT fields
        msg.setFrom( new InternetAddress( "cmpe273projecttest@gmail.com" ) );
        msg.setRecipients( Message.RecipientType.TO,InternetAddress.parse("manoranjan.sriramagiri@gmail.com") );
        msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse("cmpe273projecttest@gmail.com"));
        msg.setSentDate( new Date());
        msg.setSubject( "Current trending #tags" );
        
        msg.setText( "New trending #tag is" );
    
        Transport.send( msg );

    }catch(Exception E){
        System.out.println( "Oops something has gone pearshaped!");
        System.out.println( E );
    }
}
}