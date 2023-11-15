package christmas.View;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView{
    DecimalFormat decFormat = new DecimalFormat("###,###");

    public void printDate(int month, int day) {
        System.out.println(month + TextMsg.VAR_MONTH.label + " "
                + day + TextMsg.SHOW_INTRO.label);
    }

    public void printOrder(List<List<String>> menu) {
        System.out.println();
        System.out.println(TextMsg.SHOW_ORDERED_MENU.label);
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(menu.get(i).get(0) + " " + menu.get(i).get(1)
                    + TextMsg.VAR_COUNT.label);
        }
        System.out.println();
    }

    public void printBeforeTotal(int price) {
        System.out.println(TextMsg.SHOW_INIT_TOTAL_PRICE.label);
        System.out.println(decFormat.format(price) + TextMsg.VAR_WON.label);
        System.out.println();
    }

    public void printGiftMenu(String giftProduct, int giftCount, boolean gift) {
        System.out.println(TextMsg.SHOW_GIFT_MENU.label);
        if (gift == false) {
            System.out.println(TextMsg.NO.label);
        }
        if (gift == true) {
            System.out.println(giftProduct + " " + giftCount + TextMsg.VAR_COUNT.label);
        }
        System.out.println();
    }

    public void printBenefitIndex(List<List<String>> benefits) {
        System.out.println(TextMsg.SHOW_BENEFITS.label);
        if (benefits == null) {
            System.out.println(TextMsg.NO.label);
        }
        if (benefits != null) {
            for (int i = 0; i < benefits.size(); i++) {
                System.out.println(benefits.get(i).get(0) + TextMsg.COL.label + " -"
                        + decFormat.format(Integer.parseInt(benefits.get(i).get(1))) + TextMsg.VAR_WON.label);
            }
        }
        System.out.println();
    }

    public void printTotalBenefits(int price) {
        System.out.println(TextMsg.SHOW_TOTAL_BENEFITS.label);
        String minus="-";
        if(price==0){
            minus="";
        }
        System.out.println(minus + decFormat.format(price) + TextMsg.VAR_WON.label);
        System.out.println();
    }

    public void printTotalPrice(int price) {
        System.out.println(TextMsg.SHOW_EXPECTED_TOTAL_PRICE.label);
        System.out.println(decFormat.format(price) + TextMsg.VAR_WON.label);
        System.out.println();
    }

    public void printEventBadge(String badge){
        System.out.println(TextMsg.EVENT_BEDGE.label);
        if(badge==null){
            System.out.println(TextMsg.NO.label);
        }
        if(badge!=null){
            System.out.println(badge);
        }
        System.out.println();
    }
}