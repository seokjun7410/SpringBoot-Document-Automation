package com.document.automation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(
            @RequestBody @Valid SignUpRequest signUpRequest
    ) {
        ID id = new ID(1L);
        return new ResponseEntity<>(DataResponseFormat.response(2000, id), CREATED);
    }
}
