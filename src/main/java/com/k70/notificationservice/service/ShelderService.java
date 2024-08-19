package com.k70.notificationservice.service;

import com.k70.notificationservice.dto.BookingResponseDTO;
import com.k70.notificationservice.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class ShelderService {
    private final NotificationRepository notificationRepository;

    @Autowired
    protected RestTemplateService restTemplateService;

    public ShelderService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;

    }


//    @Scheduled(cron = "*/5 * * * * *")
//    public void sendToUsersReminders() {
//        System.out.println("sendToUsersReminders");
//        UUID uuid = UUID.fromString("d290f1ee-6c54-4b01-90e6-d701748f0851");
//
//        BookingResponseDTO ss = restTemplateService.getBookingResponseDTO(uuid);
//        System.out.println(ss);

    @Scheduled(cron = "*/5 * * * * *")
    public void sendToUsersReminders() {
        System.out.println("sendToUsersReminders");
        List<BookingResponseDTO> in = restTemplateService.getBookingResponseDTO(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(2));


        System.out.println(in);

//        notificationRepository.deleteAll();
//
//        notificationRepository


//        logger.info("Getting mailingListCollection...");
//        Collection<MailingList> mailingListCollection = mailingListService.getAllMailingList();
//        for (MailingList mailingList : mailingListCollection) {
//            if (mailingList != null) {
//                SendMessage mes = new SendMessage();
//                mes.setChatId(mailingList.getChatId());
//                mes.setText(mailingList.getMessage());
//                logger.info("Send message to user (chatId): " + mes.getChatId());
//                sendMessageToUser(mes);
//                mailingListService.deleteMessageFromMailingList(mailingList.getId());
//                logger.info("Message was deleted from DB");
//            }
//        }
    }


}
