package locale;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Locale;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class FormatLocaleTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private FormatLocale formatLocale = new FormatLocale(new Locale("hu", "HU"));

    @Test
    public void nullLocaleCurrencyShouldThrowException() throws NullPointerException {
        //Given
        exception.expect(NullPointerException.class);
        exception.expectMessage("Locale must not be null");
        // When
        formatLocale.formatCurrency(10.52, null);
    }

    @Test
    public void nullLocalePercentageShouldThrowException() throws NullPointerException {
        //Given
        exception.expect(NullPointerException.class);
        exception.expectMessage("Locale must not be null");
        // When
        formatLocale.formatPercentage(10.52, null);
    }

    @Test
    public void incorrectArgumentShouldThrowException() throws IllegalArgumentException {
        //Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Incorrect arguments!");
        // When
        formatLocale.formatCurrencyByLanguage(10.25, "", "");
    }

    @Test
    public void nonSupportedLocaleShouldThrowException() throws IllegalArgumentException {
        //Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Incorrect arguments!");
        // When
        formatLocale.formatPercentageByLanguage(95, "aa", "AA");
    }

    @Test
    public void testFormatCurrency(){
    assertThat(formatLocale.formatCurrency(10.25),equalTo("10,25\u00A0Ft"));
    }

    @Test
    public void testFormatCurrencyByLocale() {

        assertThat(formatLocale.formatCurrency(10.25, Locale.US), equalTo("$10.25"));
    }

    @Test
    public void testFormatCurrencyByLanguage() {

        assertThat(formatLocale.formatCurrencyByLanguage(10.25, "en", "US"), equalTo("$10.25"));
        assertThat(formatLocale.formatCurrencyByLanguage(10.25, "hu", "HU"), equalTo("10,25\u00A0Ft"));
    }


    @Test
    public void testFormatPercentage(){
        assertThat(formatLocale.formatPercentage(0.545), equalTo("55%"));
    }

    @Test
    public void testFormatPercentageByLocale() {

        assertThat(formatLocale.formatPercentage(0.545, Locale.US), equalTo("55%"));
    }

    @Test
    public void testFormatPercentageByLanguage() {

        assertThat(formatLocale.formatPercentageByLanguage(0.545, "en", "US"), equalTo("55%"));
        assertThat(formatLocale.formatPercentageByLanguage(0.545, "hu", "HU"), equalTo("55%"));
    }

    @Test
    public void testNumberFormatting() {

        assertThat(formatLocale.formatNumber(546389.3456, Locale.US), equalTo("546,389.35"));
    }
}
