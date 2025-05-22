/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nhom6;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Email {
    //pass:bmaa cacm jzhl yvzu
    //email:javatest3636@gmail.com
    
    private String username = ""; 
    private String password = ""; 
    

public boolean sendEmail(String to, String tieuDe, String noiDung)
{
   Properties props = new Properties();
        props.put("mail.smtp.auth", "true");                   
        props.put("mail.smtp.starttls.enable", "true");           
        props.put("mail.smtp.host", "smtp.gmail.com");            
        props.put("mail.smtp.port", "587");   


        Session session = Session.getInstance(props,
            new jakarta.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            }
        );

        try {
            // Tạo email
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));             
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));                         
            message.setSubject(tieuDe);                                   
            message.setText(noiDung);                                    

            // Gửi email
            Transport.send(message);

            System.out.println("Da gui email thanh cong toi: " + to);
            JOptionPane.showMessageDialog(new MainFrame().getFrame(), "Gửi thành công email", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new MainFrame().getFrame(), "Gửi thất bại email", "Có lỗi xảy ra", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public void setUser(String a)
    {
        username = a;
    }
    public void setPass(String a)
    {
        password = a;
    }
}

