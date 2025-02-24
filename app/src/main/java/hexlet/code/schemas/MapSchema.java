package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema<Map> {
    public MapSchema required() {
        Predicate<Map> requiredScheme = val -> val instanceof Map;
        super.addVerificator("required", requiredScheme);
        return this;
    }

    public MapSchema sizeof(int mapSize) {
        Predicate<Map> sizeofScheme = val -> (val instanceof Map) && (((Map<?, ?>) val).size() == mapSize);
        super.addVerificator("sizeof", sizeofScheme);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> schemesSet) {
        Predicate<Map> shapeScheme = mapToVerify -> {
            return schemesSet.keySet().stream().map(key -> schemesSet.get(key).isValid(
                    (String) ((Map<?, ?>) mapToVerify).get(key))).allMatch(isValid -> isValid);
        };

        super.addVerificator("shape", shapeScheme);
        return this;
    }
}
