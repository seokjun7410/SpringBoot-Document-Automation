package com.document.automation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record SignUpRequest(
        @Email
        String email,

        @NotNull
        @NotEmpty
        @Length(min = 6, max = 12) String pw,
        @Length(min = 3, max = 12) String name
) {
}
