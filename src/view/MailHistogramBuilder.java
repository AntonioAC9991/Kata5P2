package view;
import java.util.List;
import model.Histogram;
import model.Mail;

/**
 *
 * @author Admin
 */
public class MailHistogramBuilder {
    
    public static Histogram<String> build(List<Mail> list){
        Histogram<String> histo = new Histogram<>();
        for (Mail mail : list) {
            histo.increment(mail.getDomain());
        }
        return histo;
    }
}
