package hexlet.code.schemas;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.function.Predicate;

public abstract class BaseSchema<S> {
    Map<String, Predicate<S>> tests = new LinkedHashMap<>();

    public boolean isValid(S input) {
        for (var verification : tests.values()) {
            if (!verification.test(input)) {
                return false;
            }
        }

        return true;
    }

    public void addVerificator(String id, Predicate<S> verificator) {
        tests.put(id, verificator);
    }
}
