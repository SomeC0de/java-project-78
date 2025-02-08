package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StringSchema extends BaseSchema {
    private boolean isRequired = false;
    List<Predicate<String>> tests = new ArrayList<>();

    public StringSchema() {
        this.isRequired = false;
    }

    public boolean isValid(String input) {
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

    public StringSchema required() {
        this.isRequired = true;

        Predicate<String> requiredScheme = str -> str != null && !str.isEmpty();
        tests.add(requiredScheme);
        return this;
    }

    public StringSchema minLength(int length) {
        Predicate<String> lengthScheme = str -> str.length() >= length;
        tests.add(lengthScheme);
        return this;
    }

    public StringSchema contains(String sample) {
        Predicate<String> containsScheme = str -> str.contains(sample);
        tests.add(containsScheme);
        return this;
    }

    @Override
    protected boolean isInvalidDefault(Object obj) {
        return ((obj instanceof String) || ((String)obj).isEmpty());
    }
}
