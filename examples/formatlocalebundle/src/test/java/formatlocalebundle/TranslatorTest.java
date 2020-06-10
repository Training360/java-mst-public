package formatlocalebundle;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TranslatorTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void missingKeyShouldThrowException() throws IllegalArgumentException {

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Key not found");

        // When
        new Translator().englishToHungarian("door");
    }

    @Test
    public void testTranslationFromEnglishToHungarian() {

        assertThat(new Translator().englishToHungarian("window"), equalTo("ablak"));
    }

    @Test
    public void testTranslationFromEnglishToGerman() {

        assertThat(new Translator().englishToGerman("window"), equalTo("Fenster"));
    }
}
