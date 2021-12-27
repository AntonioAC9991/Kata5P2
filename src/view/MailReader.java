package view;

import model.Mail;
import java.util.List;

public interface MailReader {
    public List<Mail> read(String n); 
}