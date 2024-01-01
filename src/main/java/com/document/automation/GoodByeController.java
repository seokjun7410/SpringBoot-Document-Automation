package com.document.automation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/good-bye")
public class GoodByeController {

    @GetMapping("/test-api")
    public ResponseEntity<?> getTestAPI() {
        return ResponseEntity.ok(new ResponseOne("hoding2",99,99.9));
    }
}
