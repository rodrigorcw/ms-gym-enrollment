package com.gym.api.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PaymentTypeEnum {
    MONEY,
    DEPOSIT,
    CREDIT_CARD;

    @JsonCreator
    public static PaymentTypeEnum fromString(String value) {
        return PaymentTypeEnum.valueOf(value.toUpperCase());
    }
}
