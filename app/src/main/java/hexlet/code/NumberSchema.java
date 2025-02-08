package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {
    private boolean isRequired = false;
    List<Predicate<Integer>> tests = new ArrayList<>();

    public NumberSchema() {
        this.isRequired = false;
    }

    public boolean isValid(Integer input) {
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

    public NumberSchema required() {
        this.isRequired = true;

        Predicate<Integer> requiredScheme = val -> val instanceof Integer;
        tests.add(requiredScheme);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> positiveScheme = val
                -> Objects.isNull(val) || (val instanceof Integer && ((Integer) val) > 0);
        tests.add(positiveScheme);
        return this;
    }

    public NumberSchema range(Integer lowLim, Integer highLim) {
        Predicate<Integer> rangeScheme = val -> (val <= highLim) && (val >= lowLim);
        tests.add(rangeScheme);
        return this;
    }

    @Override
    protected boolean isInvalidDefault(Object obj) {
        return !(obj instanceof Integer);
    }
}
