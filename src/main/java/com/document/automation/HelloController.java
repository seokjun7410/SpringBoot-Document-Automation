package com.document.automation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/test-api")
    public ResponseEntity<?> getTestAPI() {
        return ResponseEntity.ok(new ResponseOne("hoding",26,70.5));
    }

    @PostMapping("/test-api")
    public ResponseEntity<?> postTestAPI(@RequestBody @Valid RequestOne requestOne) {
        return ResponseEntity.ok().build();
    }
}
