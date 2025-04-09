package com.gym.api.application.dto;

import com.gym.api.domain.enums.MembershipStatusEnum;

import java.math.BigDecimal;

public class MembershipDto {

    private String name;
    private String description;
    private BigDecimal monthlyPrice;
    private MembershipStatusEnum status;

    public MembershipDto() {
    }

    public MembershipDto(String name, String description, BigDecimal monthlyPrice, MembershipStatusEnum status) {
        this.name = name;
        this.description = description;
        this.monthlyPrice = monthlyPrice;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(BigDecimal monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }

    public MembershipStatusEnum getStatus() {
        return status;
    }

    public void setStatus(MembershipStatusEnum status) {
        this.status = status;
    }

}
