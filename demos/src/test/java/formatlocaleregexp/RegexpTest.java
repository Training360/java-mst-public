package formatlocaleregexp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class RegexpTest {

    @Test
    public void testPatternMatcher() {
       Pattern pattern = Pattern.compile("J([a-z]+)a");
       Matcher matcher = pattern.matcher("Jakara");
       assertThat(matcher.matches(), equalTo(true));

       Matcher matcher1 = pattern.matcher("Java and Jakarta");
        List<String> s = new ArrayList<>();
       while(matcher1.find()) {
           s.add(matcher1.group(1));
       }
       assertThat(s, equalTo(Arrays.asList("av", "akart")));

       assertThat("Java".matches("J[a-z]+a"), equalTo(true));

       assertThat("Java and Jakarta".replaceAll("J[a-z]+a", "xxx"),
               equalTo("xxx and xxx"));
    }
}
