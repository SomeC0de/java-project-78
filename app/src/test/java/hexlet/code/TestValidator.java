package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public final class TestValidator {
    private Validator v;
    @BeforeEach
    void setup() {
        v = new Validator();
    }

    @Test
    void string() {
        Assertions.assertInstanceOf(StringSchema.class, v.string());
    }

    @Test
    void number() {
        Assertions.assertInstanceOf(NumberSchema.class, v.number());
    }

    @Test
    void map() {
        Assertions.assertInstanceOf(MapSchema.class, v.map());
    }
}
