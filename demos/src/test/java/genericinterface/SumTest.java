package genericinterface;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SumTest {

    @Test
    public void testSum() {
        List<Integer> l = Arrays.asList(1, 3, 5, 6, 8);
        int sum = Summarizer.sum(l, new ValueExtractor<Integer>() {
            @Override
            public int extract(Integer o) {
                return o.intValue();
            }
        });
        assertThat(sum, equalTo(23));

        List<String> s = Arrays.asList("x", "xxx", "xxxxx");
        int sum2 = Summarizer.sum(s, new ValueExtractor<String>() {
            @Override
            public int extract(String o) {
                return o.length();
            }
        });
        assertThat(sum2, equalTo(9));
    }
}
