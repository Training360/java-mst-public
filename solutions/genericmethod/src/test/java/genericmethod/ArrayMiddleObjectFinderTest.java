package genericmethod;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.equalTo;

public class ArrayMiddleObjectFinderTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowExceptionIfNull() {
        exception.expect(NullPointerException.class);

        //Then
        new ArrayMiddleObjectFinder().findMiddleObject(null);
    }

    @Test
    public void shouldThrowExceptionIfEmptyArgument() {
        exception.expect(IllegalArgumentException.class);

        //Then
        new ArrayMiddleObjectFinder().findMiddleObject();
    }


    @Test
    public void evenLengthArrayShouldThrowException() throws IllegalArgumentException {

        // Given
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Even number of elements");

        // When
        new ArrayMiddleObjectFinder().findMiddleObject("", "");
    }


    @Test
    public void testReturnedObject() {

        //Given
        String[] words = new String[]{"First word", "Middle word", "Last word"};
        LocalDate[] birthDates = new LocalDate[]{LocalDate.of(2000, 12, 12), LocalDate.of(1996, 1, 12), LocalDate.of(1987, 10, 17)};

        //When
        ArrayMiddleObjectFinder finder = new ArrayMiddleObjectFinder();

        //Then
        Assert.assertThat(finder.findMiddleObject(words), equalTo("Middle word"));
        Assert.assertThat(finder.findMiddleObject(birthDates).toString(), equalTo("1996-01-12"));
    }
}
