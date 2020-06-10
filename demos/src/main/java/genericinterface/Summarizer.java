package genericinterface;

import java.util.List;

public class Summarizer {

    public static int sum(List<?> l, ValueExtractor extractor) {
        int sum = 0;
        for (Object o: l) {
            int value = extractor.extract(o);
            sum += value;
        }
        return sum;
    }
}
