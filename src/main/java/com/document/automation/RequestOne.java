package com.document.automation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record RequestOne(
        @Email String email,
        @NotEmpty @NotNull @Length(min = 3,max = 6) String name,
        @NotEmpty @NotNull @Length(min = 2, max = 10) String alias
) {
}
