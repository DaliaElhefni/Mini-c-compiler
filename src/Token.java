public class Token {
    public String type;
    public String value;
    public Integer startIndex;

    public Token() {
        this.type = "";
        this.value = "";
        this.startIndex = -1;
    }

    public Token(String type, String value, Integer startIndex) {
        this.type = type;
        this.value = value;
        this.startIndex = startIndex;
    }
}
