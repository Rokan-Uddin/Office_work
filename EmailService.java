import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private FileService fileService;

    public void sendEmailWithAttachment(String to, String subject, String text) throws MessagingException, IOException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);

        byte[] fileContent = fileService.createFileContent(text);
        ByteArrayResource byteArrayResource = new ByteArrayResource(fileContent);

        helper.addAttachment("example.txt", byteArrayResource);

        mailSender.send(message);
    }
}
