package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema<Map> {
    public MapSchema required() {
        super.setRequired();
        return this;
    }

    public MapSchema sizeof(int mapSize) {
        Predicate<Map> sizeofScheme = val -> val.size() == mapSize;
        super.addVerificator("sizeof", sizeofScheme);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> schemesSet) {
        Predicate<Map> shapeScheme = mapToVerify -> schemesSet.keySet().stream().allMatch(key ->
                schemesSet.get(key).isValid((String) mapToVerify.get(key)));

        super.addVerificator("shape", shapeScheme);
        return this;
    }
}
