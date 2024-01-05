package com.document.automation.member;

import com.document.automation.SignUpRequest;
import com.document.automation.docs.BaseDocs;
import com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper;
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.payload.RequestFieldsSnippet;
import org.springframework.restdocs.payload.ResponseFieldsSnippet;
import org.springframework.restdocs.restassured.RestDocumentationFilter;

import java.util.List;

import static com.document.automation.docs.Identifier.ADMIN_SIGN_UP_200_OK;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;

public class SignUpDocs extends BaseDocs {
    private static final String identifier = ADMIN_SIGN_UP_200_OK;
    private static final String description = "관리자 계정을 생성할 수 있습니다.";
    private static final String summary = "관리자 생성";

    public static RestDocumentationFilter success200Filter() {
        RestDocumentationFilter restDocumentationFilter = RestAssuredRestDocumentationWrapper.document(
                // identifier, 이를 이용해 adoc파일을 저장할 디렉토리를 생성한다
                SignUpDocs.identifier, SignUpDocs.description, SignUpDocs.summary,
                SignUpDocs.globalDefaultHeader(),
                SignUpDocs.request(),
                SignUpDocs.response200()
        );
        return restDocumentationFilter;
    }

    public static RestDocumentationFilter validationFilter(String identifier) {
        return RestAssuredRestDocumentationWrapper
                .document(identifier, SignUpDocs.description, SignUpDocs.summary,
                        SignUpDocs.globalDefaultHeader(),
                        SignUpDocs.request(),
                        SignUpDocs.defaultExceptionResponse()
                );
    }

    private static RequestFieldsSnippet request() {
        ConstraintDescriptions userConstraints = new ConstraintDescriptions(SignUpRequest.class);
        List<String> emailConstrains = userConstraints.descriptionsForProperty("email");
        List<String> nameConstrains = userConstraints.descriptionsForProperty("name");
        List<String> pwConstrains = userConstraints.descriptionsForProperty("pw");

        return requestFields(
                fieldWithPath("name").description(convertForDescription(nameConstrains)),
                fieldWithPath("email").description(convertForDescription(emailConstrains)),
                fieldWithPath("pw").description(convertForDescription(pwConstrains))
        );
    }

    private static ResponseFieldsSnippet response200() {
        return responseFields(
                fieldWithPath("status").description("커스텀 상태코드"),
                fieldWithPath("data").description("응답 데이터 래퍼 클래스"),
                fieldWithPath("data.id").description("생성된 관리자 Id")
        );
    }


}

