package com.document.automation.member;


import com.document.automation.ApiTest;
import com.document.automation.SignUpRequest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static com.document.automation.docs.Identifier.ADMIN_SIGN_UP_EMAIL_VALIDATION;
import static com.document.automation.docs.Identifier.ADMIN_SIGN_UP_PW_VALIDATION;
import static org.assertj.core.api.Assertions.assertThat;

class MemberControllerTest extends ApiTest {


    @Test
    public void 관리자_회원가입_API_PW_실패() {
        RequestFactory.signUp.pw = "1234";
        final SignUpRequest signUpRequest = RequestFactory.signUp.create();

        final var response = RestAssured.given(spec).log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .filter(SignUpDocs.validationFilter(ADMIN_SIGN_UP_PW_VALIDATION))
                .body(signUpRequest)
                .when()
                .post("/member/sign-up")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .log().all().extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.BAD_REQUEST.value());

        RequestFactory.signUp.clear();
    }



    @Test
    public void 관리자_회원가입_API_EMAIL_실패() {
        RequestFactory.signUp.email = "1234";
        final SignUpRequest signUpRequest = RequestFactory.signUp.create();

        final var response = RestAssured.given(spec).log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .filter(SignUpDocs.validationFilter(ADMIN_SIGN_UP_EMAIL_VALIDATION))
                .body(signUpRequest)
                .when()
                .post("/member/sign-up")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .log().all().extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.BAD_REQUEST.value());
        RequestFactory.signUp.clear();

    }
}