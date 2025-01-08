package com.apiplatform.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendWelcomeEmail(String to, String apiKey) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject("Welcome to API Platform");
            helper.setText("""
                <html>
                    <body>
                        <h2>Welcome to API Platform!</h2>
                        <p>Your API key is: <strong>%s</strong></p>
                        <p>Keep this key safe and do not share it with anyone.</p>
                    </body>
                </html>
                """.formatted(apiKey), true);

            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }

    public void sendApiKeyResetEmail(String to, String newApiKey) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject("API Key Reset");
            helper.setText("""
                <html>
                    <body>
                        <h2>Your API Key Has Been Reset</h2>
                        <p>Your new API key is: <strong>%s</strong></p>
                        <p>If you did not request this change, please contact support immediately.</p>
                    </body>
                </html>
                """.formatted(newApiKey), true);

            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }

    public void sendPasswordResetEmail(String email, String resetToken) {
    }
}
