package nestedclasses.query;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TrainerQueryTest {

    @Test
    public void testFindByName() {
        List<Trainer> trainers = Arrays.asList(
                new Trainer("John Doe", 100),
                new Trainer("Jack Doe", 300),
                new Trainer("Jane Doe", 500)
        );

        Trainer trainer = new TrainerQuery(trainers).findFirstByName("Jack Doe");
        assertThat(trainer.getName(), equalTo("Jack Doe"));
        assertThat(trainer.getSalary(), equalTo(300));
    }

    @Test
    public void testFindBySalary() {
        List<Trainer> trainers = Arrays.asList(
                new Trainer("John Doe", 100),
                new Trainer("Jack Doe", 300),
                new Trainer("Jane Doe", 500)
        );

        Trainer trainer = new TrainerQuery(trainers).findFirstBySalary(400);
        assertThat(trainer.getName(), equalTo("Jane Doe"));
        assertThat(trainer.getSalary(), equalTo(500));

    }

    @Test
    public void testFindByNameCriteria() {
        List<Trainer> trainers = Arrays.asList(
                new Trainer("John Doe", 100),
                new Trainer("Jack Doe", 300),
                new Trainer("Jane Doe", 500)
        );

        TrainerQuery.NameCriteria criteria = new TrainerQuery.NameCriteria("John Doe");

        Trainer trainer = new TrainerQuery(trainers).findFirst(criteria);
        assertThat(trainer.getName(), equalTo("John Doe"));
        assertThat(trainer.getSalary(), equalTo(100));
    }
}
