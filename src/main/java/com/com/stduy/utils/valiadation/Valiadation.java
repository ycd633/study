package com.com.stduy.utils.valiadation;

import java.util.regex.Pattern;

public class Valiadation {

    /*
     휴대폰 유효성 검사
     xxx-xxx-xxxx
     xxx-xxxx-xxxx
     */
    public boolean validPhone(String data)
    {
        String pattern = "^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$";
        boolean flag = Pattern.matches(pattern, data);
        return flag;
    }

    /*
    이메일 유효성 검사
     */
    public boolean validEmail(String data)
    {
        String pattern = "^[a-zA-Z\\d+-\\_.]+@[a-zA-Z\\d-]+\\.[a-zA-Z\\d-.]+$";
        boolean flag = Pattern.matches(pattern, data);
        return flag;
    }
    /*
    영문 유효성 검사
     */
    public boolean validEng(String data)
    {
        String pattern = "^[a-zA-Z]+$";
        boolean flag = Pattern.matches(pattern, data);
        return flag;
    }

    /*
    한글 유효성 검사
     */
    public boolean validKor(String data)
    {
        String pattern = "^[가-힣\\s]+$";
        boolean flag = Pattern.matches(pattern, data);
        return flag;
    }

    /*
    한글, 영어, 숫자 유효성 검사
     */
    public boolean validEngKorNum(String data)
    {
        String pattern = "^[\\da-zA-Zㄱ-ㅎ가-힣]*$";
        boolean flag = Pattern.matches(pattern, data);
        return flag;
    }
    /*
    숫자 유효성 검사
     */
    public boolean validNum(String data)
    {
        String pattern = "^[\\d]*$";
        boolean flag = Pattern.matches(pattern, data);
        return flag;
    }
    /*
    중복값 3회 이상인 경우
     */
    public boolean validRepetitions3(String data){
        String pattern = "^(\\w)(.*\\1){2,}$";
        boolean flag = Pattern.matches(pattern, data);
        return flag;
    }

    /*
   중복값 5회 이상인 경우
    */
    public boolean validRepetitions5(String data){
        String pattern = "^(\\w)(.*\\1){2,}$";
        boolean flag = Pattern.matches(pattern, data);
        return flag;
    }
}
