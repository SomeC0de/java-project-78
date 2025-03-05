package hexlet.code.schemas;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.function.Predicate;

public abstract class BaseSchema<S> {
    private final Map<String, Predicate<S>> tests = new LinkedHashMap<>();
    private boolean isTest = false;

    public final void enableTests() {
        this.isTest = true;
    }

    public final boolean isValid(S input) {
        if (input == null) {
            return !this.isTest;
        }
        for (var verification : tests.values()) {
            if (!verification.test(input)) {
                return false;
            }
        }

        return true;
    }

    public final void addVerificator(String id, Predicate<S> verificator) {
        tests.put(id, verificator);
    }
}
