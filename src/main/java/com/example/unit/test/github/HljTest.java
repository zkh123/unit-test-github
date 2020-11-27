package com.example.unit.test.github;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HljTest {

    public final static Integer Withdraw_Success =1;

    public static void main(String[] args) {
//        test01();
        test2();
    }

    private static void test2(){
        List<ListAndWithdrawInfoDto> listAndWithdrawInfoDtos = new ArrayList<>();
        ListAndWithdrawInfoDto listAndWithdrawInfoDto1 = new ListAndWithdrawInfoDto();
        listAndWithdrawInfoDto1.setWithdrawStatus(0);listAndWithdrawInfoDto1.setBorrowerId(111134343l);listAndWithdrawInfoDto1.setListingId(2143244l);
        listAndWithdrawInfoDtos.add(listAndWithdrawInfoDto1);
        ListAndWithdrawInfoDto listAndWithdrawInfoDto2 = new ListAndWithdrawInfoDto();
        listAndWithdrawInfoDto2.setWithdrawStatus(1);listAndWithdrawInfoDto2.setBorrowerId(111134343l);listAndWithdrawInfoDto2.setListingId(2143244l);
        listAndWithdrawInfoDtos.add(listAndWithdrawInfoDto2);
        ListAndWithdrawInfoDto listAndWithdrawInfoDto3 = new ListAndWithdrawInfoDto();
        listAndWithdrawInfoDto3.setWithdrawStatus(1);listAndWithdrawInfoDto3.setBorrowerId(111134343l);listAndWithdrawInfoDto3.setListingId(2143244l);
        listAndWithdrawInfoDtos.add(listAndWithdrawInfoDto3);

        List<ListAndWithdrawInfoDto> collect= listAndWithdrawInfoDtos.stream()
                .filter(ele -> ele.getWithdrawStatus() != null)
                .filter(ele -> ele.getWithdrawStatus() == 1)
                .collect(Collectors.toList());
        if (collect.size() == 0) { //新客.没有提现成功过
            System.out.println("新客");
        }else{
            System.out.println("老客");
        }
    }

    private static void test01(){
        System.out.println("HljStep01 我搞点事情！");
        String startVersion = "3.2.0";
        String appVersion = "3.1.9";
        if(appVersion.compareToIgnoreCase(startVersion)>=0){
            System.out.println(false);
        }else {
            System.out.println(true);
        }
    }

}
