package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// TBD: required(), minLength() and contains() are all TESTS functions, isValid() is trigger to each function and
//      we need a storage, which accumulates every TEST that will be performed. After tests are accumulated they all
//      executes inside stream in isValid().
public class StringSchema {
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

    private boolean isInvalidDefault(String s) {
        return s == null || s.isEmpty();
    }
}
