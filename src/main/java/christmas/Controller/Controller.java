package christmas.Controller;

import christmas.Model.Model;
import christmas.View.OutputView;
import christmas.View.InputView;
import christmas.View.OutputView;
import java.util.List;

public class Controller {
    int date;
    List<List<String>> order;
    int beforetotal;
    boolean gift;
    List<List<String>> benefitIndex;
    int price;
    String badge;
    public void getDateandOrder(){
        InputView inputView= new InputView();
        date=inputView.readDate();
        order = inputView.readMenu();
    }
    public void calculation(){
        Model model= new Model();
        beforetotal = model.beforeTotal(order);
        gift=model.giftMenu(beforetotal);
        benefitIndex=model.benefitIndex(date, order,beforetotal);
        price = model.totalbenefits(benefitIndex);
        badge=model.checkBadge(price);
    }
    public void printResult(){
        OutputView outputView =new OutputView();
        outputView.printDate(12, date);
        outputView.printOrder(order);
        outputView.printBeforeTotal(beforetotal);
        outputView.printGiftMenu("샴페인", 1, gift);
        outputView.printBenefitIndex(benefitIndex);
        outputView.printTotalBenefits(price);
        outputView.printTotalPrice(beforetotal-price);
        outputView.printEventBadge(badge);
    }
}






