package com.document.automation.member;


import com.document.automation.SignUpRequest;

public class RequestFactory {

    public class signUp{
        public static String email = "rkskek@naver.com";
        public static String pw = "password";
        public static String name = "아무개";

        public static SignUpRequest create() {
            return new SignUpRequest(email, pw, name);
        }

        public static void clear(){
            email = "rkskek@naver.com";
            pw = "password";
            name = "아무개";
        }
    }

}

