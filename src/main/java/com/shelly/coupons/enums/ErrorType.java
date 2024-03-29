package com.shelly.coupons.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorType {

    GENERAL_ERROR(600, "General error", "Unknown general error", true),
    FAILED_TO_GENERATE_ID(601, "Failed to generate id", "Id generation failed", false),
    ID_NOT_FOUND(602, "Id not found", "Id not found in database", false),
    SQL_ERROR(603, "SQL error", "There is SQL error", false),
    NAME_ALREADY_EXIST_ERROR(604, "Name already exist", "This name already exist in database", false),
    DATABASE_ERROR(605, "Database error", "Database access error", false),
    EMAIL_NOT_VALID_ERROR(606, "Email not valid", "This email address is not valid", false),
    NOT_ENOUGH_COUPONS_AVAILABLE(607, "Not enough com.shelly.coupons", "There is not enough com.shelly.coupons available", false),
    PASSWORD_ERROR(608, "Wrong password", "Wrong password entered", false),
    USER_NOT_FOUND(609, "User not found", "User is not found in database", false),
    COUPON_EXPIRED(610, "Coupon expired", "Coupon already expired", false),
    COUPON_NOT_STARTED(611, "Coupon not started", "This coupon is not started, will be available in a few days", false),
    COUPON_DATES_NOT_VALID(612, "Coupon dates not valid", "This coupon start date cannot be after end date", false),
    LOGIN_FAILED(613, "Login failed", "Cannot log into system", false),
    ACCESS_DENIED(614, "Access denied", "You have no rights to access", false),
    INCORRECT_CUSTOMER(615, "Incorrect customer data", "Some of customer data is absent", false),
    INCORRECT_USER(616, "Incorrect user data", "Some of user data is absent", false),
    INCORRECT_COMPANY(617, "Incorrect company data", "Some of company data is absent", false),
    NO_PAIRED_USER_FOR_CUSTOMER(618, "No paired user for customer", "No paired user for customer", false),
    INCORRECT_VALUE(619, "You must insert a value", "This value can't be null", false),
    INVALID_VALUE(620, "Please pay attention", "You have entered an invalid symbol", false);

    private int errorCode;
    private String errorMessage;
    private String errorName;
    private boolean isShowStackTrace;

    private ErrorType(int errorCode, String errorName, String errorMessage, boolean isShowStackTrace) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorName = errorName;
        this.isShowStackTrace = isShowStackTrace;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorName() {
        return errorName;
    }

    public boolean isShowStackTrace() {
        return this.isShowStackTrace;
    }


}
