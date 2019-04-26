package Parser;

//decl                         -> var_decl | fun_decl
public class Rule3 implements Node{
    Rule4 rule4;
    Rule5 rule5;

    public Rule3(Rule4 rule4) {
        this.rule4 = rule4;
    }

    public Rule3(Rule5 rule5) {
        this.rule5 = rule5;
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
        System.out.println(tabs + "Rule 3: decl -> var_decl | fun_decl");
        System.out.println();
        if(rule4!=null) rule4.printNode(number+1) ;
        System.out.println();
        if(rule5!=null) rule5.printNode(number+1) ;
    }
}
