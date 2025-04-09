package com.gym.api.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gym.api.domain.enums.PaymentTypeEnum;
import com.gym.api.domain.enums.StatusEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TB_ENROLLMENT")
public class Enrollment {

    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDateEnrollment;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDateEnrollment;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @Enumerated(EnumType.STRING)
    private PaymentTypeEnum paymentType;

    private BigDecimal amount;

    private int durationMonths;

    public int getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
    }

    public Enrollment() {
    }

    public Enrollment(Long id, Long memberNumber, LocalDate startDateEnrollment, LocalDate endDateEnrollment, StatusEnum status, PaymentTypeEnum paymentType, BigDecimal amount, int durationMonths) {
        this.id = id;
        this.memberNumber = memberNumber;
        this.startDateEnrollment = startDateEnrollment;
        this.endDateEnrollment = endDateEnrollment;
        this.status = status;
        this.paymentType = paymentType;
        this.amount = amount;
        this.durationMonths = durationMonths;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public PaymentTypeEnum paymentType() {
        return paymentType;
    }

    public void setPaymentMethod(PaymentTypeEnum paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
