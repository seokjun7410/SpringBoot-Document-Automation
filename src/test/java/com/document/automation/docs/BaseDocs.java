package com.document.automation.docs;

import org.springframework.http.HttpHeaders;
import org.springframework.restdocs.headers.RequestHeadersSnippet;
import org.springframework.restdocs.payload.ResponseFieldsSnippet;

import java.util.List;

import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.requestHeaders;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

public class BaseDocs {
    public static RequestHeadersSnippet globalDefaultHeader() {
        return requestHeaders(
                headerWithName(HttpHeaders.CONTENT_TYPE).description("Content Type Header")
        );
    }

    public static ResponseFieldsSnippet defaultExceptionResponse() {
        return responseFields(
                fieldWithPath("timestamp").description("현재 시간"),
                fieldWithPath("status").description("HttpStatus Value"),
                fieldWithPath("error").description("HttpStatus"),
                fieldWithPath("path").description("요청된 경로(path)")
        );
    }

    protected static String convertForDescription(List<String> constraints) {
        if(constraints.size() == 1)
            return "["+constraints.get(0)+"]";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < constraints.size()-1; i++) {
            stringBuilder
                    .append("[")
                    .append(constraints.get(i))
                    .append("], ");
        }

        stringBuilder
                .append("[")
                .append(constraints.get(constraints.size()-1))
                .append("]");

        return stringBuilder.toString();
    }
}
