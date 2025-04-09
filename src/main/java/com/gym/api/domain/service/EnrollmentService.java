package com.gym.api.domain.service;

import com.gym.api.application.dto.EnrollmentDTO;
import com.gym.api.domain.enums.StatusEnum;
import com.gym.api.domain.model.Enrollment;

import java.util.List;

public interface EnrollmentService {

    List<EnrollmentDTO> findAll();

    EnrollmentDTO findById(Long id);

    EnrollmentDTO createEnrollment(Enrollment enrollment);

    void deleteById(Long id, StatusEnum status);

    void updateStatus(Long id, StatusEnum statusEnum);
}
