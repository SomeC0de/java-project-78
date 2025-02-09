package hexlet.code;

import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {
    public NumberSchema required() {
        Predicate<Object> requiredScheme = val -> val instanceof Integer;
        super.addVerificator(requiredScheme);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Object> positiveScheme = val
                -> Objects.isNull(val) || (val instanceof Integer && ((Integer) val) > 0);
        super.addVerificator(positiveScheme);
        return this;
    }

    public NumberSchema range(Integer lowLim, Integer highLim) {
        Predicate<Object> rangeScheme = val -> ((Integer) val) <= highLim && ((Integer) val) >= lowLim;
        this.addVerificator(rangeScheme);
        return this;
    }
}
