package christmas.View;

import camp.nextstep.edu.missionutils.Console;
import christmas.Model.ValidationChecker;

import java.util.List;


public class View {
    public void View(){
        System.out.println(TextMsg.WELCOME.label);

    }
}
public class inputView{
    private int temp;
    public int readDate(){
        System.out.println(TextMsg.ASK_DATE.label);
        do {
            String input = Console.readLine();
            temp = ValidationChecker.dateChecker(input);
        }
        while(temp!=0);
        return temp;
    }
    public List<String> readMenu(){
        System.out.println(TextMsg.ASK_DISHES.label);
        do {
            String input = Console.readLine();
            temp = ValidationChecker.menuChecker(input);
        }
        while(temp!=0);
        return temp;
    }
}

class outputView{}
