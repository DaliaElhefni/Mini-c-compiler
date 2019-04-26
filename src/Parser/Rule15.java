package Parser;

//local_decls                  -> var_decl local_decls | empty
public class Rule15 implements Node {
    Rule4 rule4;
    Rule15 rule15;

    public Rule15(Rule4 rule4, Rule15 rule15) {
        this.rule4 = rule4;
        this.rule15 = rule15;
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
        System.out.println(tabs + "Rule 15: local_decls -> var_decl local_decls | empty");
        System.out.println();
        if(rule4!=null) rule4.printNode(number+1) ;
        System.out.println();
        if(rule15!=null) rule15.printNode(number+1) ; else System.out.println(getTabs(number+1)
                + "Rule 15(local_decls): null");
    }
}
