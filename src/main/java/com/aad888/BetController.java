package com.aad888;

public class BetController {
    public static void main(String[] args) {
        //888aad.COM的账号密码
        String username1 = "freebuf002";
        String password1 = "abc081623";
//        new Api(username , password).doIt();

        int [] betMoney = {5,5,5,10,5,5,5,10};//
//        int [] betMoney = {5,12,27,57,129,219};//
//        int [] betMoney = {10,30,70,150,310,640,1300,2650};
//        int [] betMoney = {5,15,35,75,155,320};
//        int [] betMoney = {5,5,5,5,5,5,5,35};
        new Api(username1 , password1 , betMoney).doIt();

    }
}
