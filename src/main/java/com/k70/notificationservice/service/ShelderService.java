package com.k70.notificationservice.service;

import com.k70.notificationservice.dto.BookingResponseDTO;
import com.k70.notificationservice.dto.NotificationDTO;
import com.k70.notificationservice.repository.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;

@Slf4j
@Component
public class ShelderService {
    private final NotificationService notificationService;
    private final RestTemplateService restTemplateService;

    public ShelderService(NotificationService notificationService, RestTemplateService restTemplateService) {
        this.notificationService = notificationService;
        this.restTemplateService = restTemplateService;
    }

    //TODO @Scheduled(cron = "0 0 10 * * *") in prod profile
    @Scheduled(cron = "0 */2 * * * *")
    public void sendToUsersReminders() {
        log.info("Start ShelderService sendToUsersReminders @Scheduled(cron = \"0 */2 * * * *\")");
        List<BookingResponseDTO> in = restTemplateService.getBookingResponseDTO(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(2));

        in.forEach(e -> {
            String message = sendEmailSSL(e);
            log.info("{} reminder send to {}", e.id(), e.customer().email());
            notificationService.save(new NotificationDTO(null, e.customer().id(), message, LocalDateTime.now()));
        });
        log.info("All messages sent");
    }

    private String sendEmailSSL(BookingResponseDTO inDTO) {
        final String username = "AnchDN@gmail.com";
        final String password = "haue upsc vgtu mfzh";
        String out = null;


        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("AnchDN@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(inDTO.customer().email())
            );
            message.setSubject("Booking reminder");
            out = "Hello dear " + inDTO.customer().firstName() + " " + inDTO.customer().lastName()
                    + "\n\n Your room number " + inDTO.room().number() +
                    " in " + inDTO.hotel().name() + " is ready for tomorrow (from " + inDTO.startDate() +
                    " to " + inDTO.endDate() + ")";
            message.setText(out);
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return out;
    }
}
