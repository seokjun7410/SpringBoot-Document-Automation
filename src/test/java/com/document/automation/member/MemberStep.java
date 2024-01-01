package com.document.automation.member;

import com.document.automation.DataResponseFormat;
import com.document.automation.ID;
import com.document.automation.JsonBinding;
import com.document.automation.SignUpRequest;
import com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.restdocs.restassured.RestDocumentationFilter;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

/**
 * step 에서는 HTTP status 까지 검증
 *
 * @cause : step을 재사용 하는 시점에서는 response.Type,HttpStatus 의존 최소화
 */
public class MemberStep {
    public static DataResponseFormat<ID> signUp_API(RequestSpecification spec) {


        RestDocumentationFilter restDocumentationFilter = RestAssuredRestDocumentationWrapper.document(
                // identifier, 이를 이용해 adoc파일을 저장할 디렉토리를 생성한다
                SignUpDocs.identifier, SignUpDocs.description, SignUpDocs.summary,
                SignUpDocs.globalDefaultHeader(),
                SignUpDocs.signUpRequest(),
                responseFields(
                        fieldWithPath("status").description("커스텀 상태코드"),
                        fieldWithPath("data").description("응답 데이터 래퍼 클래스"),
                        fieldWithPath("data.id").description("생성된 관리자 Id")
                )
        );

        final SignUpRequest signUpRequest = RequestFactory.signUp.create();

        final var response = RestAssured.given(spec).log().all()
                .filter(restDocumentationFilter)
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


