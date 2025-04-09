package com.gym.api.application.dto;

import com.gym.api.domain.enums.PaymentTypeEnum;
import com.gym.api.domain.enums.StatusEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EnrollmentDTO {

    private Long memberNumber;
    private LocalDate startDateEnrollment;
    private LocalDate endDateEnrollment;
    private StatusEnum status;
    private PaymentTypeEnum paymentType;
    private BigDecimal amount;
    private int durationMonths;
    private MembershipDto membership; // User id another MS


    public int getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
    }

    public MembershipDto getMembership() {
        return membership;
    }

    public void setMembershipDto(MembershipDto membership) {
        this.membership = membership;
    }

    public Long getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(Long memberNumber) {
        this.memberNumber = memberNumber;
    }

    public LocalDate getStartDateEnrollment() {
        return startDateEnrollment;
    }

    public void setStartDateEnrollment(LocalDate startDateEnrollment) {
        this.startDateEnrollment = startDateEnrollment;
    }

    public LocalDate getEndDateEnrollment() {
        return endDateEnrollment;
    }

    public void setEndDateEnrollment(LocalDate endDateEnrollment) {
        this.endDateEnrollment = endDateEnrollment;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public PaymentTypeEnum getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentTypeEnum paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}



