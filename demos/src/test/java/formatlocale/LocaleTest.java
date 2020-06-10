package formatlocale;

import org.junit.Test;

import java.util.Arrays;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class LocaleTest {

    @Test
    public void testLocale() {
        Locale locale = new Locale("hu", "HU");
        assertThat(locale.getLanguage(), equalTo("hu"));
        assertThat(locale.getCountry(), equalTo("HU"));
    }
}
