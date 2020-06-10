package genericclass;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class ArraySearchTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowExceptionIfNull() {
        exception.expect(NullPointerException.class);

        //Then
        new ArraySearch().getFirstAndLastWord(null);
    }

    @Test
    public void shouldThrowExceptionIfEmptyArgument() {
        exception.expect(IllegalArgumentException.class);

        //Then
        new ArraySearch().getFirstAndLastWord(new String[]{});
    }

    @Test
    public void testReturnedDataPairObject() {

        //Given
        String[] words = new String[]{"First word", "Middle word", "Last word"};

        //When
        DataPair<String> firstAndLast = new ArraySearch().getFirstAndLastWord(words);

        //Then
        assertThat(firstAndLast.getFirstObject(), equalTo("First word"));
        assertThat(firstAndLast.getSecondObject(), equalTo("Last word"));
    }

    @Test
    public void testReturnedDataPairObjectWithSingleObject() {

        //Given
        String[] words = new String[]{"First word"};

        //When
        DataPair<String> firstAndLast = new ArraySearch().getFirstAndLastWord(words);

        //Then
        assertThat(firstAndLast.getFirstObject(), equalTo("First word"));
        assertThat(firstAndLast.getSecondObject(), equalTo("First word"));
    }
}
