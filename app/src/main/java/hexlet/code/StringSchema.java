package hexlet.code;

public class StringSchema {
    private int minLength;
    private String sampleToCheck;
    private boolean isRequired = false;

    public StringSchema() {
        this.minLength = 0;
        this.sampleToCheck = null;
    }

    public boolean isValid(String input) {
        if (this.isRequired) {
            return (input.length() >= this.minLength) && input.contains(this.sampleToCheck);
        } else {
            return true;
        }
    }

    public StringSchema required() {
        this.isRequired = true;
        return this;
    }

    public StringSchema minLength(int length) {
        this.minLength = length;
        return this;
    }

    public StringSchema contains(String sample) {
        this.sampleToCheck = sample;
        return this;
    }
}
