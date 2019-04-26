package Parser;

//program                      -> decl decl_list_dash
public class Rule1 implements Node{
    Rule3 rule3;
    Rule2 rule2;

    public Rule1(Rule3 rule3 , Rule2 rule2)
    {
        this.rule3 = rule3;
        this.rule2 = rule2;
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
        System.out.println(tabs + "Rule 1: program -> decl decl_list_dash");
        System.out.println();
        if(rule3!=null) rule3.printNode(number+1) ;
        System.out.println();
        if(rule2!=null) rule2.printNode(number+1) ; else System.out.println(getTabs(number+1)+ "Rule 2(decl_list_dash): null");
    }
}
