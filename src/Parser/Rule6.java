package Parser;

//params                       -> param_list | empty
public class Rule6 implements Node {
    Rule7 rule7;

    public Rule6(Rule7 rule7) {
        this.rule7 = rule7;
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
        System.out.println(tabs + "Rule 6: params -> param_list | empty");
        System.out.println();
        if(rule7!=null) rule7.printNode(number+1) ;
    }
}
