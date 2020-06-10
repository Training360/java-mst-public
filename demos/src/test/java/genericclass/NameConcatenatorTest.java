package genericclass;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class NameConcatenatorTest {

    @Test
    public void testConcat() {
        List<Human> humans = Arrays.asList(new Human("John"), new Human("Jack"), new Human("Jane"));
        String s = new NameConcatenator().concat(humans);
        assertThat(s, equalTo("John, Jack, Jane, "));
    }

    @Test
    public void testAdd() {
        List<Human> l = new ArrayList<>();
        new NameConcatenator().add(l);
        assertThat(l.get(0).getName(), equalTo("Jack"));

        List<Trainer> l2 = new ArrayList<>();
        new NameConcatenator().add(l2);
        assertThat(l2.get(0).getName(), equalTo("Jack"));
    }
}
