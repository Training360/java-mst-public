package formatlocaleregexp;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RegexpValidatorTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void emptyParameterStringShouldThrowException() throws IllegalArgumentException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Empty string");
        // When
        new RegexpValidator().validateEmail("    ");
    }

    @Test
    public void nullStringShouldThrowExceptionInYearStringValidation() throws IllegalArgumentException {
        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Empty string passed!");
        // When
        new RegexpValidator().validateYearString(null);
    }

    @Test
    public void testValidateEmail() {

        assertThat(new RegexpValidator().validateEmail("email&email.com"), is(false));
        assertThat(new RegexpValidator().validateEmail("email@email.com"), is(true));
        assertThat(new RegexpValidator().validateEmail("e_m.a.I_l@email.com"), is(true));
        assertThat(new RegexpValidator().validateEmail("email@email.email.hu.eu.com"), is(true));
    }

    @Test
    public void testValidateAcademicYear() {

        assertThat(new RegexpValidator().validateAcademicYear("2014-2015"), is(true));
        assertThat(new RegexpValidator().validateAcademicYear("2014/2015"), is(false));
        assertThat(new RegexpValidator().validateAcademicYear("946-947"), is(false));
        assertThat(new RegexpValidator().validateAcademicYear("2114-2115"), is(false));
    }

    @Test
    public void testValidateYearString() {

        assertThat(new RegexpValidator().validateYearString("2014"), is(true));
        assertThat(new RegexpValidator().validateYearString("3014"), is(false));
        assertThat(new RegexpValidator().validateYearString("896"), is(false));
    }
}
