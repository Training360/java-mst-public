package nestedclasses.anonymousinner;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class OuterTest {

    @Test
    public void testGetListSortedIgnoreCase() {
        List<String> words = Arrays.asList("AAA", "BBB", "CDD", "abb", "bcc", "ccc");
        assertThat(new Outer(words).getListSortedIgnoreCase(), equalTo(Arrays.asList("AAA", "abb", "BBB", "bcc", "ccc", "CDD")));
    }
}
