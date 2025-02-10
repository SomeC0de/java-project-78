package hexlet.code;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
    public MapSchema required() {
        Predicate<Object> requiredScheme = val -> val instanceof Map;
        super.addVerificator(requiredScheme);
        return this;
    }

    public MapSchema sizeof(int mapSize) {
        Predicate<Object> sizeofScheme = val -> (val instanceof Map) && (((Map<?, ?>) val).size() == mapSize);
        super.addVerificator(sizeofScheme);
        return this;
    }
}
