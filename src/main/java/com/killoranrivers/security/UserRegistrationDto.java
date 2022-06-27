package com.killoranrivers.security;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@FieldMatch.List({
        @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
        @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
})
@Data
@NoArgsConstructor
public class UserRegistrationDto {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    @Email
    @NotEmpty
    private String email;
    @Email
    @NotEmpty
    private String confirmEmail;

    @AssertTrue
    private Boolean terms;
}
