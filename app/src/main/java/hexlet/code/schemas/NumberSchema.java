package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        Predicate<Integer> requiredScheme = val -> val instanceof Integer;
        super.addVerificator(requiredScheme);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> positiveScheme = val
                -> Objects.isNull(val) || (val instanceof Integer && ((Integer) val) > 0);
        super.addVerificator(positiveScheme);
        return this;
    }

    public NumberSchema range(Integer lowLim, Integer highLim) {
        Predicate<Integer> rangeScheme = val -> ((Integer) val) <= highLim && ((Integer) val) >= lowLim;
        this.addVerificator(rangeScheme);
        return this;
    }
}
