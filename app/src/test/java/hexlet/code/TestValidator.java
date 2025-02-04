package hexlet.code;

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
}
