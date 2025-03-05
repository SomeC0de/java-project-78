package hexlet.code.schemas;
import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        Predicate<String> requiredScheme = str -> !str.isEmpty();
        super.addVerificator("required", requiredScheme);
        super.enableTests();

        return this;
    }

    public StringSchema minLength(int length) {
        Predicate<String> lengthScheme = str -> ((String) str).length() >= length;
        super.addVerificator("length", lengthScheme);
        return this;
    }

    public StringSchema contains(String sample) {
        Predicate<String> containsScheme = str -> ((String) str).contains(sample);
        super.addVerificator("contains", containsScheme);
        return this;
    }
}
