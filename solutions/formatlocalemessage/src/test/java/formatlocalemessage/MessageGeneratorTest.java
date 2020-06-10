package formatlocalemessage;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MessageGeneratorTest {

    @Test
    public void testGenerateForecastText() {
        assertThat(new MessageGenerator().generateForecastText("light rain", 12, "Budapest"),
                equalTo("Tomorrow expect light rain with 12  \u00B0C temperature in Budapest."));
    }

    @Test
    public void testGenerateLotteryAnnouncement() {
        //Then
        assertThat(new MessageGenerator().generateLotteryAnnouncement("John Smith"),
                equalTo("Yesterday John Smith won a staggering sum of 500 M"));
    }
}
