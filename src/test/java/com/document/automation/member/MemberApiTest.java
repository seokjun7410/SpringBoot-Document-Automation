package com.document.automation.member;


import com.document.automation.ApiTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberApiTest extends ApiTest {


    //회원가입으로 계정을 생성 할 수 있다.
    @Test
    public void 관리자_회원가입_API() {
        final var response = MemberStep.signUp_API(spec);
        assertThat(response.getStatus()).isEqualTo(2000);
        assertThat(response.getData().getValue()).isNotNull();
    }



}