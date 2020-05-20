package ru.itis.sem1.Services;

import org.springframework.stereotype.Service;
import ru.itis.sem1.Models.User;

@Service
public interface MailSenderService {
    public void sendMail(User user);
}