import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import static org.apache.commons.text.StringEscapeUtils.escapeHtml4;


public class NotificationSender {

    public static void sendNotification(Participant santa, Participant child, String condition, Credentials credentials) {
        MailConfig client = new MailConfig(credentials);

        try {
            Message message = new MimeMessage(client.getSession());
            message.setFrom(new InternetAddress(client.getEmailAddress()));

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(santa.getEmail()));
            message.setSubject("### CONFIDENTIAL ### YOU ARE A SECRET SANTA");

            String msg = new StringBuilder()
                    .append("Ciao ").append(santa.getName()).append(",<br>")
                    .append("Il bimbo fortunato a cui dovrai fare il tuo dono &egrave;: <strong>").append(child.getName()).append("</strong>!<br>")
                    .append("La condizione del dono a cui dovrai sottostare &egrave;: <strong>").append(escapeHtml4(condition)).append("</strong><br><br>")
                    .append("Ricorda che il budget massimo &egrave; di 10 euro!").append("<br><br>")
                    .append("Buon Natale!").append("<br>")
                    .append("The Secret Santa extractor").toString();

            message.setContent(msg, "text/html");
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static class MailConfig {

        private final Properties prop;
        private final Credentials credentials;

        public MailConfig(Credentials credentials) {
            this.credentials = credentials;
            prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");
        }

        protected Session getSession() {
            return Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(credentials.getUsername(), credentials.getPassword());
                }
            });
        }

        protected String getEmailAddress() {
            return credentials.getUsername();
        }
    }
}
