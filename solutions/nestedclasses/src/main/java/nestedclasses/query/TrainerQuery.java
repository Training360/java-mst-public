package nestedclasses.query;

import java.util.List;

public class TrainerQuery {

    private List<Trainer> trainers;

    public TrainerQuery(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public Trainer findFirst(Criteria criteria) {
        for (Trainer trainer: trainers) {
            if (criteria.test(trainer)) {
                return trainer;
            }
        }
        throw new IllegalArgumentException("Cannot find trainer");
    }

    public Trainer findFirstByName(String name) {
        return findFirst(new NameCriteria(name));
    }

    public Trainer findFirstBySalary(int minSalary) {
        return findFirst(new SalaryCriteria(minSalary));
    }

    public interface Criteria {
        boolean test(Trainer trainer);
    }

    public static class NameCriteria implements Criteria {

        private String name;

        public NameCriteria(String name) {
            this.name = name;
        }

        @Override
        public boolean test(Trainer trainer) {
            return trainer.getName().equals(name);
        }
    }

    public static class SalaryCriteria implements Criteria {
        private int minSalary;

        public SalaryCriteria(int minSalary) {
            this.minSalary = minSalary;
        }

        @Override
        public boolean test(Trainer trainer) {
            return trainer.getSalary() >= minSalary;
        }
    }
}
