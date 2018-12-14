package com.cloud.mvc.example.business.common.constants;

import java.util.regex.Pattern;

public interface PatternConstants {

    String phone = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
    String email = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";

    Pattern PhonePattern = Pattern.compile(phone);
    Pattern EmailPattern = Pattern.compile(email);



}
