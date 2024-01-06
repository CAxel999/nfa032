import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Classe récupérant la date de la machine
 */
public class Datejour {
    public String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
