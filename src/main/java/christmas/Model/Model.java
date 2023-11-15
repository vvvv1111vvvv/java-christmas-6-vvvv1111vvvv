package christmas.Model;

import java.util.*;

public class Model {
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    String disc_dday = "크리스마스 디데이 할인";
    String disc_wekday = "평일 할인";
    String disc_wekend = "주말 할인";
    String disc_spec = "특별 할인";
    String disc_gif = "증정 이벤트";

    public Model() {
        map.put("양송이수프", 6000);
        map.put("타파스", 5500);
        map.put("시저샐러드", 8000);
        map.put("티본스테이크", 55000);
        map.put("바비큐립", 54000);
        map.put("해산물파스타", 35000);
        map.put("크리스마스파스타", 25000);
        map.put("초코케이크", 15000);
        map.put("아이스크림", 5000);
        map.put("제로콜라", 3000);
        map.put("레드와인", 60000);
        map.put("샴페인", 25000);
    }

    public int beforeTotal(List<List<String>> order) {
        int totalPrice = 0;
        for (int i = 0; i < order.size(); i++) {
            totalPrice = totalPrice + map.get(order.get(i).get(0)) * Integer.parseInt(order.get(i).get(1));
        }
        return totalPrice;
    }

    public boolean giftMenu(int totalPrice) {
        if (totalPrice > 120000) {
            return true;
        }
        return false;
    }

    public List<List<String>> benefitIndex(
            int date, List<List<String>> order, int beforeTotal) {
        int discount_dday = 0;
        int discount_weekday = 0;
        int discount_weekends = 0;
        int discount_special = 0;
        int discount_gift = 0;
        List<List<String>> temp;
        List<List<String>> result = new ArrayList<>();
        if (beforeTotal < 10000) {
            return null;
        }
        if (date <= 25) {
            discount_dday = 1000 + (date-1) * 100;
        }
        for (int i = 0; i < order.size(); i++) {
            if (((3 <= date && date <= 7) || (10 <= date && date <= 14)
                    || (17 <= date && date <= 21 || (24 <= date && date <= 28)
                    || (date == 31))) && (Arrays.asList("초코케이크", "아이스크림").contains(order.get(i).get(0)))) {
                discount_weekday = discount_weekday + 2023 * Integer.parseInt(order.get(i).get(1));
            }
        }
        for (int i = 0; i < order.size(); i++) {
            if (((1 <= date && date <= 2) || (8 <= date && date <= 9)
                    || (15 <= date && date <= 16 || (22 <= date && date <= 23)
                    || (29 <= date && date <= 30))) && (Arrays.asList("티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타").contains(order.get(i).get(0)))) {
                discount_weekends = discount_weekends + 2023 * Integer.parseInt(order.get(i).get(1));
            }
        }
        if (Arrays.asList(3, 10, 17, 24, 25, 31).
                contains(date)) {
            discount_special = 1000;
        }
        if (giftMenu(beforeTotal)) {
            discount_gift = 25000;
        }

        temp = Arrays.asList(Arrays.asList(disc_dday, Integer.toString(discount_dday)), Arrays.asList(disc_wekday, Integer.toString(discount_weekday)),
                Arrays.asList(disc_wekend, Integer.toString(discount_weekends)), Arrays.asList(disc_spec, Integer.toString(discount_special)), Arrays.asList(disc_gif, Integer.toString(discount_gift)));
        for (int i = 0; i < temp.size(); i++) {
            if (!Objects.equals(temp.get(i).get(1), Character.toString('0'))) {
                result.add(temp.get(i));
            }
        }
        return result;
    }
    public int totalbenefits(List<List<String>> result){
        if(result==null){
            return 0;
        }
        int price=0;
        for (int i=0;i<result.size();i++){
            price += Integer.parseInt(result.get(i).get(1));
        }
        return price;
    }
    public String checkBadge(int price){
        if(20000<=price){
            return "산타";
        }
        if(10000<=price){
            return "트리";
        }
        if(5000<= price){
            return "별";
        }
        return null;
    }

}
