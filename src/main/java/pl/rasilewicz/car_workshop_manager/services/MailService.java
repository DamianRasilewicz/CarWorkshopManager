package pl.rasilewicz.car_workshop_manager.services;

public interface MailService {

        void sendEmail(String to, String subject, String content);
    }
