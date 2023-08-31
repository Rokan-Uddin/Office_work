import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
public class EmailController {

    @Autowired
    private FileService fileService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/send-email")
    public String sendEmail() throws IOException, MessagingException {
        String text = "This is the content of the text file.";
        File attachment = fileService.createAndWriteToFile(text);
        
        emailService.sendEmailWithAttachment("recipient@example.com", "Subject", "Email body", attachment);

        return "Email sent with attachment.";
    }
}
