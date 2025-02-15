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

    public MapSchema shape(Map<String, BaseSchema<String>> schemesSet) {
        Predicate<Object> shapeScheme = mapToVerify -> {
            return schemesSet.keySet().stream().map(key -> schemesSet.get(key).isValid(
                    (String) ((Map<?, ?>) mapToVerify).get(key))).allMatch(isValid -> isValid);
        };

        super.addVerificator(shapeScheme);
        return this;
    }
}
