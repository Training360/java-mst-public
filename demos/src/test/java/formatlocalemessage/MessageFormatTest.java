package formatlocalemessage;

import org.junit.Test;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MessageFormatTest {

    @Test
    public void testFormat() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2018-06-01 10:00:00");

        String s1 = MessageFormat.format("Hello {0}!", "Jack");
        assertThat(s1, equalTo("Hello Jack!"));

        String s2 = MessageFormat.format("Hello {0}, the time is {1}!",
                "Joe", date);
        System.out.println(s2);

        String s3 = MessageFormat.format("Hello {0}, the time is {1,date,medium}!",
                "Joe", date);
        System.out.println(s3);

        String s4 = MessageFormat.format("Hello {0}, the time is {1,date,medium} {1,time,full}!",
                "Joe", date);
        System.out.println(s4);

        MessageFormat format = new MessageFormat("Hello {0}, the time is {1,date,short} {1,time,short}!",
                new Locale("hu", "HU"));
        assertThat(format.format(new Object[]{"Joe", date}), equalTo("Hello Joe, the time is 2018. 06. 01. 10:00!"));

        MessageFormat enFormat = new MessageFormat("Hello {0}, the time is {1,date,short} {1,time,short}!",
                Locale.UK);
        assertThat(enFormat.format(new Object[]{"Joe", date}),
                equalTo("Hello Joe, the time is 01/06/2018 10:00!"));

    }

    @Test
    public void testMessageFormatWithResourceBundle() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2018-06-01 10:00:00");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("welcome", new Locale("hu", "HU"));
        String pattern = resourceBundle.getString("hello");
        MessageFormat messageFormat = new MessageFormat(pattern, new Locale("hu", "HU"));
        String s = messageFormat.format(new Object[]{"Jack", date});
        assertThat(s,
                equalTo("Hello Jack, the time is 2018. 06. 01. 10:00!"));
    }


}
