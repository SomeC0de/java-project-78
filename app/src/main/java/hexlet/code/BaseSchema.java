package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private boolean isRequired = false;
    List<Predicate<Object>> tests = new ArrayList<>();

    public boolean isValid(Object input) {
        if (!this.isRequired && isInvalidDefault(input)) {
            return true;
        }

        for (var verification : tests) {
            if (!verification.test(input)) {
                return false;
            }
        }

        return true;
    }

    protected abstract boolean isInvalidDefault(Object obj);
}
