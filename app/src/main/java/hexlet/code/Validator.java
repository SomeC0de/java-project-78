package hexlet.code;

public class Validator {
    public Validator() { }

    public StringSchema string() {
        return new StringSchema();
    }

    public NumberSchema number() {
        return new NumberSchema();
    }
}
