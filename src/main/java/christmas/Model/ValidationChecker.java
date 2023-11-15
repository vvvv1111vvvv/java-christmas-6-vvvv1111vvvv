package christmas.Model;

import java.util.*;

import static java.lang.Integer.parseInt;

enum ERRMSG {
    ERROR_REQ_NEW_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ERROR_REQ_NEW_INPUT("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    public final String label;

    ERRMSG(String s) {
        this.label = s;
    }
}

public class ValidationChecker {
    static final List<String> apit = new ArrayList<>(Arrays.asList("양송이수프", "타파스", "시저샐러드"));
    static final List<String> main = new ArrayList<>(Arrays.asList("티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타"));
    static final List<String> dese = new ArrayList<>(Arrays.asList("초코케이크", "아이스크림"));
    static final List<String> drin = new ArrayList<>(Arrays.asList("제로콜라", "레드와인", "샴페인"));
    static List<String> not_drin = new ArrayList<>();

    static {
        not_drin.addAll(apit);
        not_drin.addAll(main);
        not_drin.addAll(dese);
    }


    public static int dateChecker(String input) {
        try {
            int temp = Integer.parseInt(input);
            if (temp < 1 || temp > 31) {
                throw new IllegalArgumentException();
            }
            return temp;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println(ERRMSG.ERROR_REQ_NEW_DATE.label);
            return 0;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println(ERRMSG.ERROR_REQ_NEW_DATE.label);
            return 0;
        }

    }

    static String menuDivider_val(String tempList_i, List<String> temp_menu) throws IllegalArgumentException {
        String val_menu;
        if (tempList_i.split("-").length != 2) {
            throw new IllegalArgumentException(ERRMSG.ERROR_REQ_NEW_INPUT.label);
        }
        val_menu = tempList_i.split("-")[0];
        if (!apit.contains(val_menu)
                && !main.contains(val_menu)
                && !dese.contains(val_menu)
                && !drin.contains(val_menu)) {
            throw new IllegalArgumentException(ERRMSG.ERROR_REQ_NEW_INPUT.label);
        } else if (temp_menu.contains(val_menu)) {
            throw new IllegalArgumentException(ERRMSG.ERROR_REQ_NEW_INPUT.label);
        }
        return val_menu;
    }

    static int menuDivider_count(String tempList_i) throws IllegalArgumentException, NumberFormatException {
        int val_count;
        try {
            val_count = Integer.parseInt(tempList_i.split("-")[1]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERRMSG.ERROR_REQ_NEW_INPUT.label);
        }

        if (val_count < 1) {
            throw new IllegalArgumentException(ERRMSG.ERROR_REQ_NEW_INPUT.label);
        }
        return val_count;
    }

    static void checkMax20(List<String> temp_menu, List<Integer> temp_count) throws IllegalArgumentException{
        int temp_num = 0;
        for (int i = 0; i < temp_menu.size(); i++) {
            temp_num = temp_num + temp_count.get(i);
        }
        if (temp_num > 20) {
            throw new IllegalArgumentException(ERRMSG.ERROR_REQ_NEW_INPUT.label);
        }
    }

    static void checkAllDrink(List<String> temp_menu) throws IllegalArgumentException{
        if (drin.containsAll(temp_menu)) {
            throw new IllegalArgumentException(ERRMSG.ERROR_REQ_NEW_INPUT.label);
        }
    }

    static List<List<String>> makeList(List<String> temp_menu, List<Integer> temp_count) {
        List<List<String>> total = new ArrayList<>();
        for (int i = 0; i < temp_menu.size(); i++) {
            List<String> elem = new ArrayList<>();
            elem.add(temp_menu.get(i));
            elem.add(Integer.toString(temp_count.get(i)));
            total.add(elem);
        }
        return total;
    }

    static List<List<String>> inputDevider(List<String> temp_list) {
        List<String> temp_menu = new ArrayList<>();
        List<Integer> temp_count = new ArrayList<>();
        try {
            for (int i = 0; i < temp_list.size(); i++) {
                temp_menu.add(menuDivider_val(temp_list.get(i), temp_menu));
                temp_count.add(menuDivider_count(temp_list.get(i)));
            }
            checkMax20(temp_menu, temp_count);
            checkAllDrink(temp_menu);
        } catch (NumberFormatException e) {
            System.out.println(ERRMSG.ERROR_REQ_NEW_INPUT.label);
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println(ERRMSG.ERROR_REQ_NEW_INPUT.label);
            e.printStackTrace();
            return null;
        }
        return makeList(temp_menu, temp_count);
    }

    public static List<List<String>> menuChecker(String input) {
        List<String> temp_list = Arrays.asList(input.split(","));
        return inputDevider(temp_list);
    }
}
