public class Token implements Comparable{
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
    @Override
    public int compareTo(Object o) {
        return (this.startIndex.compareTo(((Token) o).startIndex));
    }
}