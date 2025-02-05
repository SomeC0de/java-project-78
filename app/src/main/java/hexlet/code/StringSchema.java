package hexlet.code;

// TBD: required(), minLength() and contains() are all TESTS functions, isValid() is trigger to each function and
//      we need a storage, which accumulates every TEST that will be performed. After tests are accumulated they all
//      executes inside stream in isValid().
public class StringSchema {
    private int minLength;
    private String sampleToCheck;
    private boolean isRequired = false;

    public StringSchema() {
        this.minLength = 0;
        this.sampleToCheck = null;
        this.isRequired = false;
    }

    public boolean isValid(String input) {
        if (!this.isRequired) {
            return isInvalidDefault(input);
        }

        return isValidRequired(input);
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

    private boolean isInvalidDefault(Object obj) {
        return !(obj instanceof String) || ((String)obj).isEmpty();
    }

    private boolean isValidRequired(Object obj) {
        return (obj instanceof String)
                && !((String)obj).isEmpty()
                && (((String)obj).length() >= this.minLength)
                && (((String)obj).contains(this.sampleToCheck));
    }
}
