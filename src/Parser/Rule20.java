package Parser;

//expr_dash                    -> expr3 expr_dash | empty
public class Rule20 implements Node{
    Rule22 rule22;
    Rule20 rule20;

    public Rule20(Rule22 rule22, Rule20 rule20) {
        this.rule22 = rule22;
        this.rule20 = rule20;
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
        System.out.println(tabs + "Rule 20: expr_dash -> expr3 expr_dash | empty");
        System.out.println();
        if(rule22!=null) rule22.printNode(number+1) ;
        System.out.println();
        if(rule20!=null) rule20.printNode(number+1) ; else System.out.println(getTabs(number+1)+ "Rule 20(expr_dash): null");
    }
}
