package Parser;

//args                         -> arg_list | empty
public class Rule26 implements Node {
    Rule24 rule24;

    public Rule26(Rule24 rule24) {
        this.rule24 = rule24;
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
        System.out.println(tabs + "Rule 26: args -> arg_list | empty");
        System.out.println();
        if(rule24!=null) rule24.printNode(number+1) ;
    }
}
