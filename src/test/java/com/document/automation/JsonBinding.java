package com.document.automation;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class JsonBinding {

    public static <T> T getData(ExtractableResponse<Response> response, Class<T> bindClass) {
        return response.body().jsonPath().getObject("data",bindClass
        );
    }

    public static int getCustomStatus (ExtractableResponse<Response> response) {
        return response.body().jsonPath().getInt("status");
    }

}
