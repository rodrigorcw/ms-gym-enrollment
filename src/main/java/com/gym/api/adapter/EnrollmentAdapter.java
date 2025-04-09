package com.gym.api.adapter;

import com.gym.api.application.dto.EnrollmentDTO;
import com.gym.api.domain.model.Enrollment;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentAdapter {

    public static EnrollmentDTO toDto(Enrollment enrollment) {

        EnrollmentDTO toDto = new EnrollmentDTO();
        toDto.setMemberNumber(enrollment.getMemberNumber());
        toDto.setStartDateEnrollment(enrollment.getStartDateEnrollment());
        toDto.setEndDateEnrollment(enrollment.getEndDateEnrollment());
        toDto.setStatus(enrollment.getStatus());
        toDto.setPaymentType(enrollment.paymentType());
        toDto.setDurationMonths(enrollment.getDurationMonths());
        return toDto;
    }


}

