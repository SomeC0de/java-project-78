package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {
    List<Predicate<Object>> tests = new ArrayList<>();

    public boolean isValid(Object input) {
        for (var verification : tests) {
            if (!verification.test(input)) {
                return false;
            }
        }

        return true;
    }

    public void addVerificator(Predicate<Object> verificator) {
        tests.add(verificator);
    }
}
