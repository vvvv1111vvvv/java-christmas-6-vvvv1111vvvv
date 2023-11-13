package christmas.Model;

import static java.lang.Integer.parseInt;

enum ERRMSG {
    ERROR_REQ_NEW_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    public final String label;

    ERRMSG(String s) {
        this.label = s;
    }
}

public class ValidationChecker {
    public static int intChecker(String input) throws NumberFormatException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new NumberFormatException(ERRMSG.ERROR_REQ_NEW_DATE.label);
        }

    }
    public static int dateChecker(String input) {
        try {
            int temp = intChecker(input);
            if (temp < 1 || temp > 31) {
                throw new IllegalArgumentException(ERRMSG.ERROR_REQ_NEW_DATE.label);
            }
            return temp;
        } catch (NumberFormatException e) {
            return 0;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0;
        }

    }
    public static int menuChecker(String input) {


    }
}
