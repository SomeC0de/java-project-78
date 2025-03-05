package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        Predicate<Integer> requiredScheme = val -> val instanceof Integer;
        super.addVerificator("required", requiredScheme);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> positiveScheme = val
                -> Objects.isNull(val) || (val instanceof Integer && ((Integer) val) > 0);
        super.addVerificator("positive", positiveScheme);
        return this;
    }

    public NumberSchema range(Integer lowLim, Integer highLim) {
        Predicate<Integer> rangeScheme = val -> ((Integer) val) <= highLim && ((Integer) val) >= lowLim;
        this.addVerificator("range", rangeScheme);
        return this;
    }
}
