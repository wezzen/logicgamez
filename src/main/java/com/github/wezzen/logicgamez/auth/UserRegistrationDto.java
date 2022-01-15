package com.github.wezzen.logicgamez.auth;

import javax.validation.constraints.*;

public class UserRegistrationDto {

  private @Email(message = "Email should be valid") @NotNull String email = "";

  private @Email(message = "Email confirmation should be valid") @NotEmpty(
      message = "Email confirmation required") String emailConfirm = "";

  private @AssertTrue(message = "You must accept the agreement") boolean terms = false;

  private @NotEmpty(message = "Password required") @Size(min = 6, max = 60) String password = "";

  private @NotEmpty(message = "Password confirmation required") @Size(min = 6, max = 60) String
      passwordConfirm = "";

  private @NotEmpty(message = "Username required") @Size(min = 2, max = 30) String username = "";

  public String getEmail() {
    return email.toLowerCase();
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getEmailConfirm() {
    return emailConfirm.toLowerCase();
  }

  public void setEmailConfirm(final String emailConfirm) {
    this.emailConfirm = emailConfirm;
  }

  public boolean isTerms() {
    return terms;
  }

  public void setTerms(final boolean terms) {
    this.terms = terms;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public String getPasswordConfirm() {
    return passwordConfirm;
  }

  public void setPasswordConfirm(final String passwordConfirm) {
    this.passwordConfirm = passwordConfirm;
  }

  public final String getUsername() {
    return username.toLowerCase();
  }

  public void setUsername(final String username) {
    this.username = username;
  }
}
