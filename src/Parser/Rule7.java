package Parser;

//param_list                   -> param param_list_dash
public class Rule7 implements Node {
    Rule9 rule9;
    Rule8 rule8;


    public Rule7(Rule9 rule9, Rule8 rule8) {
        this.rule9 = rule9;
        this.rule8 = rule8;
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
        System.out.println(tabs + "Rule 7: param_list -> param param_list_dash");
        System.out.println();
        if(rule9!=null) rule9.printNode(number+1) ;
        System.out.println();
        if(rule8!=null) rule8.printNode(number+1) ; else System.out.println(getTabs(number+1)+ "Rule 8(param_list_dash): null");
    }
}
