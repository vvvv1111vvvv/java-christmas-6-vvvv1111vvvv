package christmas.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static christmas.Model.ValidationChecker.*;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidationCheckerTest{
    /*@DisplayName("날짜예외_숫자이외입력")
    @Test
    void 날짜예외_숫자이외입력(){
        assertThatThrownBy(() -> ValidationChecker.dateChecker("##"))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("날짜예외_숫자범위이외입력")
    @Test
    void 날짜예외_숫자범위이외입력(){
        assertThatThrownBy(() -> ValidationChecker.dateChecker("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }*/
    @DisplayName("메뉴 예외 1. 음료수만 주문하는 경우")
    @Test
    void menu1Test() {

        List<List<String>> actualValue=inputDevider(List.of("제로콜라-2", "레드와인-4"));
        List<List<String>> expected= null;
        assertEquals(expected,actualValue);
    }
    @DisplayName("메뉴 예외 2. 메뉴판에 없는 메뉴를 입력하는 경우")
    @Test
    void menu2Test() {

        List<List<String>> actualValue=inputDevider(List.of("사과-2"));
        List<List<String>> expected= null;
        assertEquals(expected,actualValue);
    }
    @DisplayName("메뉴 예외 3. 메뉴의 개수는 를 1미만으로 입력한 경우")
    @Test
    void menu3Test() {

        List<List<String>> actualValue=inputDevider(List.of("양송이수프-2", "제로콜라-0"));
        List<List<String>> expected= null;
        assertEquals(expected,actualValue);
    }
    @DisplayName("메뉴 예외 4. 메뉴 형식이 예시와 다른 경우")
    @Test
    void menu4Test() {

        List<List<String>> actualValue=inputDevider(List.of("양송이수프--2"));
        List<List<String>> expected= null;
        assertEquals(expected,actualValue);
    }
    @DisplayName("메뉴 예외 5. 중복 메뉴를 입력한 경우")
    @Test
    void menu5Test() {

        List<List<String>> actualValue=inputDevider(List.of("양송이수프-2","바비큐립-12", "바비큐립-1"));
        List<List<String>> expected= null;
        assertEquals(expected,actualValue);
    }
    @DisplayName("메뉴 예외 6. 20개 초과 주문하는 경우")
    @Test
    void menu6Test() {

        List<List<String>> actualValue=inputDevider(List.of("바비큐립-21"));
        List<List<String>> expected= null;
        assertEquals(expected,actualValue);
    }
    @DisplayName("메뉴를 정상 주문하는 경우")
    @Test
    void menuPassTest() {

        List<List<String>> actualValue=inputDevider(List.of("바비큐립-4", "아이스크림-2", "제로콜라-3"));
        List<List<String>> expected= Arrays.asList(Arrays.asList("바비큐립","4"),Arrays.asList("아이스크림","2"),Arrays.asList("제로콜라","3"));
        assertEquals(expected,actualValue);
    }
    @DisplayName("menu ValidationChecker 전체 동작확인")
    @Test
    void menuChekerVerify() {

        List<List<String>> actualValue=menuChecker("바비큐립-4,아이스크림-2,제로콜라-3");
        List<List<String>> expected= Arrays.asList(Arrays.asList("바비큐립","4"),Arrays.asList("아이스크림","2"),Arrays.asList("제로콜라","3"));
        assertEquals(expected,actualValue);
    }
}