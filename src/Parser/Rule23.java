package Parser;

//expr4                        -> expr | empty
public class Rule23 implements Node {
    Rule19 rule19;

    public Rule23(Rule19 rule19) {
        this.rule19 = rule19;
    }

    @Override
    public String getTabs(Integer number) {
        String temp = "";
        for(int i=0;i<number;i++){
            temp += "\t";
        }
        return temp;
    }
    @Override
    public void printNode(Integer number) {
        String tabs = getTabs(number);
        System.out.println(tabs + "Rule 23: expr4 -> expr | empty");
        System.out.println();
        if(rule19!=null) rule19.printNode(number+1) ;
    }
}
