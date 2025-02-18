package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema<S> {
    List<Predicate<S>> tests = new ArrayList<>();

    public boolean isValid(S input) {
        for (var verification : tests) {
            if (!verification.test(input)) {
                return false;
            }
        }

        return true;
    }

    public void addVerificator(Predicate<S> verificator) {
        tests.add(verificator);
    }
}
