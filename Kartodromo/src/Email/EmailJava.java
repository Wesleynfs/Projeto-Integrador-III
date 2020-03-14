package Email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmailJava {

    private String username = "potatoemail007@gmail.com";
    private String password = "123456789Wes";
    private String to = "kako.araujo.24@gmail.com";
    private String server = "smtp.gmail.com";

    private Authenticator simpleAuth() {
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        };
        return authenticator;
    }

    public boolean EnviarEmailGmail(StringBuilder lista,String assunto,String mensagem) throws Exception {

        Properties properties = new Properties();
        properties.put("mail.transport.protocol","smtp");
        properties.put("mail.smtp.starttls","true");
        properties.put("mail.smtp.host",server);
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.user",username);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.socketFactory.port","465");
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback","false");

        Session session = Session.getInstance(properties, simpleAuth());
        session.setDebug(true);

        Transport tr;

        try {
            Message message = new MimeMessage(session);
            if (lista.indexOf(",") > 0) {
                InternetAddress[] internetAddresses = InternetAddress.parse(lista.toString());
                message.setRecipients(Message.RecipientType.CC, internetAddresses);
            } else {
                message.setRecipient(Message.RecipientType.CC, new InternetAddress(lista.toString()));
            }
            message.setFrom(new InternetAddress(username));
            message.setSubject(assunto);
            message.setText(mensagem);
            tr = session.getTransport("smtp");
            tr.connect(server,username,password);
            message.saveChanges();
            tr.sendMessage(message,message.getAllRecipients());
            tr.close();
            return true;
        } catch (Exception e) {
            throw new Exception("Não foi possivel enviar o email" + e.getMessage());
        }

    }


}
