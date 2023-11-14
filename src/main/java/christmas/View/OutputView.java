package christmas.View;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView{
    DecimalFormat decFormat = new DecimalFormat("###,###");

    public void printDate(int month, int day) {
        System.out.println(month + TextMsg.VAR_MONTH.label + " "
                + day + TextMsg.SHOW_INTRO);
    }

    public void printOrder(List<List<String>> menu) {
        System.out.println(TextMsg.SHOW_ORDERED_MENU);
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(menu.get(i).get(0) + " " + menu.get(i).get(1)
                    + TextMsg.VAR_COUNT);
        }
    }

    public void printBeforeTotal(int price) {
        System.out.println(TextMsg.SHOW_INIT_TOTAL_PRICE);
        System.out.println(decFormat.format(price) + TextMsg.VAR_WON);
    }

    public void printGiftMenu(String gift, int giftCount) {
        System.out.println(TextMsg.SHOW_GIFT_MENU);
        if (giftCount == 0) {
            System.out.println(TextMsg.NO);
        }
        if (giftCount == 1) {
            System.out.println(gift + " " + giftCount + TextMsg.VAR_COUNT);
        }
    }

    public void printBenefitIndex(List<List<String>> benefits) {
        System.out.println(TextMsg.SHOW_BENEFITS);
        if (benefits == null) {
            System.out.println(TextMsg.NO);
        }
        if (benefits != null) {
            for (int i = 0; i < benefits.size(); i++) {
                System.out.println(benefits.get(i).get(0) + TextMsg.COL + " -"
                        + decFormat.format(benefits.get(i).get(1)) + TextMsg.VAR_WON);
            }
        }
    }

    public void printTotalBenefits(int price) {
        System.out.println(TextMsg.SHOW_TOTAL_BENEFITS);
        System.out.print("-" + decFormat.format(price) + TextMsg.VAR_WON);
    }

    public void printTotalPrice(int price) {
        System.out.println(TextMsg.SHOW_EXPECTED_TOTAL_PRICE);
        System.out.println(decFormat.format(price) + TextMsg.VAR_WON);
    }

    public void printEventBadge(String badge){
        System.out.println(TextMsg.EVENT_BEDGE);
        if(badge==null){
            System.out.println(TextMsg.NO);
        }
        if(badge!=null){
            System.out.println(badge);
        }
    }
}