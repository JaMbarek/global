package com.cloud.mvc.example.business.common.constants;

import java.util.regex.Pattern;

public interface PatternConstants {

    String phone = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
    String email = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";

    String phoneOrEmail = phone + "|" + email;

//    String password = "(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}";//6-16位的数字和字母组合
    String password = ".*";//6-16位的数字和字母组合
    //身份证号码
//    String card = "^\\d{15}$|^\\d{17}[0-9Xx]$";
    String card = ".*";
    //护照
    String passCard = "^[a-zA-Z0-9]{3,21}$";
    //军官证
    String officeCard = "^[a-zA-Z0-9]{7,21}$";
    //驾驶证
    String driveCard = ".*";
    //验证码
    String verifyCode = "^\\d{6}$";
    String googleCode = "^\\d{6}$";

    //委托时的价格正则
    String entrustPrice = "^(\\d)+(\\.(\\d){0,30})?$";
    //委托时的数量正则
    String entrustCount = "^(\\d)+(\\.(\\d){0,30})?$";
    //正整数正则
    String CheckInteger = "^[1-9]*[1-9][1-9]*$";

    Pattern PhonePattern = Pattern.compile(phone);
    Pattern EmailPattern = Pattern.compile(email);
    Pattern CardPattern = Pattern.compile(card);
    Pattern PassCardPattern = Pattern.compile(passCard);
    Pattern OfficeCardPattern = Pattern.compile(officeCard);
    Pattern DriverCardPattern = Pattern.compile(driveCard);

    Pattern CheckIntegerPattern = Pattern.compile(CheckInteger);
    Pattern PasswordPattern = Pattern.compile(password);



}
