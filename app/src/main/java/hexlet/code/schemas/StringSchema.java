package hexlet.code.schemas;
import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        Predicate<String> requiredScheme = str -> !str.isEmpty();
        super.addVerificator("required", requiredScheme);
        super.setRequired();

        return this;
    }

    public StringSchema minLength(int length) {
        Predicate<String> lengthScheme = str -> str.length() >= length;
        super.addVerificator("length", lengthScheme);
        return this;
    }

    public StringSchema contains(String sample) {
        Predicate<String> containsScheme = str -> str.contains(sample);
        super.addVerificator("contains", containsScheme);
        return this;
    }
}
