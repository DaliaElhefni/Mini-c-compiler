package Parser;

//stmt_list                    -> stmt stmt_list | empty
public class Rule10 implements Node{
    Rule11 rule11;
    Rule10 rule10;

    public Rule10(Rule11 rule11, Rule10 rule10) {
        this.rule11 = rule11;
        this.rule10 = rule10;
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
        System.out.println(tabs + "Rule 10: stmt_list -> stmt stmt_list | empty");
        System.out.println();
        if(rule11!=null) rule11.printNode(number+1) ;
        System.out.println();
        if(rule10!=null) rule10.printNode(number+1) ; else System.out.println(getTabs(number+1)+ "Rule 10(stmt_list): null");
    }
}
