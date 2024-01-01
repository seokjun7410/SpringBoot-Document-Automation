package com.document.automation.member;

import com.document.automation.docs.BaseDocs;
import com.document.automation.SignUpRequest;
import com.epages.restdocs.apispec.RestAssuredRestDocumentationWrapper;
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.payload.RequestFieldsSnippet;
import org.springframework.restdocs.restassured.RestDocumentationFilter;

import java.util.List;

import static com.document.automation.docs.Identifier.ADMIN_SIGN_UP_200_OK;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;


public class SignUpDocs extends BaseDocs {
    public static String identifier = ADMIN_SIGN_UP_200_OK;
    public static String description = "관리자 계정을 생성할 수 있습니다.";
    public static String summary = "관리자 생성";

    public static RequestFieldsSnippet signUpRequest() {
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


    public static RestDocumentationFilter validationFilter(String identifier) {
        return RestAssuredRestDocumentationWrapper
                .document(identifier, SignUpDocs.description, SignUpDocs.summary,
                        SignUpDocs.globalDefaultHeader(),
                        SignUpDocs.signUpRequest(),
                        SignUpDocs.defaultExceptionResponse()
                );
    }
}
