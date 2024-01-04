package com.bruno13palhano.shopdani_stock_management;

public enum UserResponseCode {
    OK("0"),
    WRONG_PASSWORD_VALIDATION("1"),
    USER_NULL_OR_INVALID("2"),
    USERNAME_ALREADY_EXIST("3"),
    EMAIL_ALREADY_EXIST("4"),
    INCORRECT_USERNAME_OR_PASSWORD("5"),
    LOGIN_SERVER_ERROR("6"),
    INSERT_SERVER_ERROR("7"),
    UPDATE_SERVER_ERROR("8"),
    FILL_MISSING_FIELDS("9");

    private final String code;

    UserResponseCode(final String code) { this.code = code; }

    public String getCode() { return code; }
}
