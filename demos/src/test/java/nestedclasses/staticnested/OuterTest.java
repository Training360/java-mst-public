package nestedclasses.staticnested;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class OuterTest {

    @Test
    public void testOuter() {
        Outer outer = new Outer();
        assertThat(outer.saySomething(), equalTo("Hello"));
    }

    @Test
    public void testInner() {
        Outer.Inner inner = new Outer.Inner();
        assertThat(inner.sayHello(), equalTo("Hello"));
    }
}
