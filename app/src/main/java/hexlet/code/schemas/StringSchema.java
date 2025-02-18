package hexlet.code.schemas;
import java.util.function.Predicate;

public class StringSchema extends BaseSchema {
    public StringSchema required() {
        Predicate<Object> requiredScheme = str -> str instanceof String && !((String) str).isEmpty();
        super.addVerificator(requiredScheme);
        return this;
    }

    public StringSchema minLength(int length) {
        Predicate<Object> lengthScheme = str -> ((String) str).length() >= length;
        super.addVerificator(lengthScheme);
        return this;
    }

    public StringSchema contains(String sample) {
        Predicate<Object> containsScheme = str -> ((String) str).contains(sample);
        super.addVerificator(containsScheme);
        return this;
    }
}
