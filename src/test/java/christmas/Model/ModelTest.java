package christmas.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static christmas.Model.Model.*;
import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    @DisplayName("총주문금액 계산")
    @Test
    void beforeTotalTest() {
        Model model= new Model();
        int actualValue=model.beforeTotal(List.of(List.of("양송이수프", "4"),List.of("티본스테이크", "5"), List.of("제로콜라", "4")));
        int expected= 311000;
        assertEquals(expected,actualValue);
    }
    @DisplayName("증정메뉴 계산")
    @Test
    void giftMenuTest() {
        Model model= new Model();
        boolean actualValue=model.giftMenu(311000);
        boolean expected= true;
        assertEquals(expected,actualValue);
    }
    @DisplayName("혜택내역 계산")
    @Test
    void benefitIndexTest() {
        Model model= new Model();
        List<List<String>> actualValue=model.benefitIndex(12,List.of(List.of("양송이수프", "4"),List.of("티본스테이크", "5"), List.of("제로콜라", "4")),311000);
        List<List<String>> expected= List.of(List.of("크리스마스 디데이 할인","2100"),List.of("증정 이벤트","25000"));
        assertEquals(expected,actualValue);
    }
    @DisplayName("총혜택금액 계산")
    @Test
    void totalbenefitsTest() {
        Model model= new Model();
        int actualValue=model.totalbenefits(List.of(List.of("크리스마스 디데이 할인","2100"),List.of("증정 이벤트","25000")));
        int expected= 27100;
        assertEquals(expected,actualValue);
    }
    @DisplayName("12월 이벤트 배지 계산")
    @Test
    void checkBadgeTest() {
        Model model= new Model();
        String actualValue=model.checkBadge(27100);
        String expected= "산타";
        assertEquals(expected,actualValue);
    }
}