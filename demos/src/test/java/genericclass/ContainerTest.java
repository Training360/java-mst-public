package genericclass;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ContainerTest {

    @Test
    public void testCreate() {
        Container<Human> c = new Container<>(new Human("John"));
        assertThat(c.getValue().getClass(), equalTo(Human.class));
        assertThat(c.getName(), equalTo("John"));

        Container<Subject> c2 = new Container<>(new Subject("Java"));
        assertThat(c2.getValue().getClass(), equalTo(Subject.class));
        assertThat(c2.getName(), equalTo("Java"));


    }

}
