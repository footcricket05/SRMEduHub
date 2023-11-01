package chat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author dvcarrillo
 */

public class Message {
    private String username;
    private String text;
    private String time;

    public Message(String username, String text) {
        this.username = username;
        this.text = text;
        Date date = new Date();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        time = Integer.toString(hour) + ":" + Integer.toString(min);
    }

    // SET METHODS
    public void setUsername(String username) {
        this.username = username;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    // GET METHODS
    public String getUsername() {
        return username;
    }

    public String getText() {
        return text;
    }
    
    public String getTime() {
        return time;
    }
    
}
