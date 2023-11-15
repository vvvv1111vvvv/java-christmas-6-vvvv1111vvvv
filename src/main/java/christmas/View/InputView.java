package christmas.View;

import camp.nextstep.edu.missionutils.Console;
import christmas.Model.ValidationChecker;

import java.text.DecimalFormat;
import java.util.List;




public class InputView {
    public InputView(){
        System.out.println(TextMsg.WELCOME.label);
    }
    public int readDate() {
        int temp;
        System.out.println(TextMsg.ASK_DATE.label);
        do {
            String input = Console.readLine();
            temp = ValidationChecker.dateChecker(input);
        }
        while (temp == 0);
        return temp;
    }

    public List<List<String>> readMenu() {
        List<List<String>> temp_str;
        System.out.println(TextMsg.ASK_DISHES.label);
        do {
            String input = Console.readLine();
            temp_str = ValidationChecker.menuChecker(input);

        }
        while (temp_str == null);
        return temp_str;
    }
}


