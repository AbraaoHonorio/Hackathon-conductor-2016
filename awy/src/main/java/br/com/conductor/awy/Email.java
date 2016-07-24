/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.conductor.awy;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author abraao
 */
public class Email {
    
            public Email(String strExtract, String strEmail)
            {
                 Properties props = new Properties();
            /** Parâmetros de conexão com servidor Gmail */
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   return new PasswordAuthentication("voicepi.hackathon@gmail.com", "voicepi12345");
                             }
                        });

          

            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("voicepi.hackathon@gmail.com")); //Remetente

                  Address[] toUser = InternetAddress //Destinatário(s)
                             .parse(strEmail);   //"abraao.allyson@eng.ci.ufpb.br, yuri.gouveia@eng.ci.ufpb.br,wellton.thyago@eng.ci.ufpb.br"

                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject("Enviando email pelo VoicePI");//Assunto
                  message.setText("Enviei este email utilizando VoicePi \n"+ strExtract);
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);

                  

             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
            }
           
      
}




