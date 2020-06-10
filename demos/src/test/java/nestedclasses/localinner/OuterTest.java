package nestedclasses.localinner;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class OuterTest {

    @Test
    public void testSaySomething() {
        assertThat(new Outer().saySomething(), equalTo("Hello"));
    }
}
