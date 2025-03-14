package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class TestStringSchema {
    @Test
    public void test() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid("")).isTrue();
        assertThat(schema.contains("").isValid("")).isTrue();

        schema.required();

        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.isValid(null)).isFalse();

        schema.minLength(0);
        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.contains("").isValid("")).isFalse();

        assertThat(schema.isValid("what does the fox say")).isTrue();
        assertThat(schema.isValid("hexlet")).isTrue();

        schema.minLength(7);
        assertThat(schema.isValid("what does the fox say")).isTrue();
        assertThat(schema.isValid("hexlet")).isFalse();

        assertThat(schema.contains("what").isValid("what does the fox say")).isTrue();

        assertThat(schema.contains("whatthe").isValid("what does the fox say")).isFalse();

        var schema1 = v.string().required().minLength(10).minLength(4);
        assertThat(schema1.isValid("hexlet")).isTrue();
    }
}
