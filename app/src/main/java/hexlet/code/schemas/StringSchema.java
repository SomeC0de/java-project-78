package hexlet.code.schemas;
import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        Predicate<String> requiredScheme = str -> str instanceof String && !((String) str).isEmpty();
        super.addVerificator(requiredScheme);
        return this;
    }

    public StringSchema minLength(int length) {
        Predicate<String> lengthScheme = str -> ((String) str).length() >= length;
        super.addVerificator(lengthScheme);
        return this;
    }

    public StringSchema contains(String sample) {
        Predicate<String> containsScheme = str -> ((String) str).contains(sample);
        super.addVerificator(containsScheme);
        return this;
    }
}
