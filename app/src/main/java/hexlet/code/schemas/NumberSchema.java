package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        super.setRequired();
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> positiveScheme = val -> val > 0;
        super.addVerificator("positive", positiveScheme);
        return this;
    }

    public NumberSchema range(Integer lowLim, Integer highLim) {
        Predicate<Integer> rangeScheme = val -> (val <= highLim) && (val >= lowLim);
        this.addVerificator("range", rangeScheme);
        return this;
    }
}
