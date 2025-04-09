package com.gym.api.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gym.api.domain.enums.MembershipStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "TB_MEMBERSHIP")
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    @NotBlank
    private String name;

    @Column(nullable = false, length = 30)
    private String description;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal monthlyPrice;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate startMembership;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate endMembership;

    private int durationMonths;

    public int getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
    }

    public Membership() {
    }

    public Membership(Long id, String name, String description, BigDecimal monthlyPrice, LocalDate startMembership, LocalDate endMembership, MembershipStatusEnum status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.monthlyPrice = monthlyPrice;
        this.startMembership = startMembership;
        this.endMembership = endMembership;
        this.status = status;
    }


    @Enumerated(EnumType.STRING)
    private MembershipStatusEnum status;

    public Membership(Long id, String name, BigDecimal monthlyPrice, LocalDate startMembership, LocalDate endMembership, MembershipStatusEnum status) {
    }

    public Membership(Long id, String name, LocalDate endMembership) {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
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

    public LocalDate getStartMembership() {
        return startMembership;
    }

    public void setStartMembership(LocalDate startMembership) {
        this.startMembership = startMembership;
    }

    public LocalDate getEndMembership() {
        return endMembership;
    }

    public void setEndMembership(LocalDate endMembership) {
        this.endMembership = endMembership;
    }

    public MembershipStatusEnum getStatus() {
        return status;
    }

    public void setStatus(MembershipStatusEnum status) {
        this.status = status;
    }
}
