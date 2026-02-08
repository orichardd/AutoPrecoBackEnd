package richard.demo.models;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailService {

    @Value("richdd.dev.app@gmail.com")
    private String from;

    @Value("ktys svze snie kckc")
    private String password;

    @Value("richdd.dev@gmail.com")
    private String to;

    public void MandarEmail(String texto, String nome, String usuarioEmail){


        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );

            String textoCompleto = """
                    Nome: %s - Email: %s
                    %s
                    """.formatted(nome, usuarioEmail, texto);

            message.setSubject("Contato via AutoPreco");
            message.setText(textoCompleto);

            Transport.send(message);
            System.out.println("Email enviado com sucesso!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
