package com.document.automation.member;

import com.document.automation.DataResponseFormat;
import com.document.automation.ID;
import com.document.automation.JsonBinding;
import com.document.automation.SignUpRequest;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

/**
 * step 에서는 HTTP status 까지 검증
 *
 * @cause : step을 재사용 하는 시점에서는 response.Type,HttpStatus 의존 최소화
 */
public class MemberStep {
    public static DataResponseFormat<ID> signUp_API(RequestSpecification spec) {

        final SignUpRequest signUpRequest = RequestFactory.signUp.create();

        final var response = RestAssured.given(spec).log().all()
                .filter(SignUpDocs.success200Filter())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(signUpRequest)
                .when()
                .post("/member/sign-up")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .log().all().extract();

        ID bind = JsonBinding.getData(response, ID.class);
        int customStatus = JsonBinding.getCustomStatus(response);

        return new DataResponseFormat<>(customStatus, bind);
    }
}


