package com.gym.api.application.service;

import com.gym.api.application.dto.EnrollmentDTO;
import com.gym.api.application.dto.MembershipDto;
import com.gym.api.domain.enums.StatusEnum;
import com.gym.api.domain.model.Enrollment;
import com.gym.api.domain.service.EnrollmentService;
import com.gym.api.exception.EnrollmentNotFoundException;
import com.gym.api.exception.ResourceNotFoundException;
import com.gym.api.infra.feign.MembershipClient;
import com.gym.api.infra.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.gym.api.adapter.EnrollmentAdapter.toDto;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    @Autowired
    private MembershipClient membershipClient;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public List<EnrollmentDTO> findAll() {
        List<Enrollment> listEnrollment = enrollmentRepository.findAll();
        List<EnrollmentDTO> listResult = new ArrayList<>();
        for (Enrollment enrollment : listEnrollment) {
            var dto = toDto(enrollment);
            MembershipDto membership = membershipClient.getAllDetailsMembershipById(enrollment.getMemberNumber());
            dto.setMembershipDto(membership);
            dto.setAmount(membership.getMonthlyPrice().multiply(BigDecimal.valueOf(enrollment.getDurationMonths())));
            enrollment.setEndDateEnrollment(enrollment.getStartDateEnrollment().plusMonths(enrollment.getDurationMonths()));
            listResult.add(dto);
        }
        return listResult;
    }

    @Override
    public EnrollmentDTO findById(Long id) {
        var getId = enrollmentRepository.findById(id).orElseThrow(() -> new EnrollmentNotFoundException((id)));
        return toDto(getId);
    }

    @Override
    public EnrollmentDTO createEnrollment(Enrollment enrollment) {
        enrollment.setStatus(StatusEnum.ACTIVE);
        enrollment.setEndDateEnrollment(enrollment.getStartDateEnrollment().plusMonths(enrollment.getDurationMonths()));
        var saved = enrollmentRepository.save(enrollment);
        return toDto(saved);
    }

    @Override
    public void updateStatus(Long id, StatusEnum statusEnum) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membership not found"));
        enrollment.setStatus(statusEnum);
        enrollmentRepository.save(enrollment);
    }

    @Override
    public void deleteById(Long id, StatusEnum status) {
        if (enrollmentRepository.existsById(id)) {
            enrollmentRepository.deleteById(id);
        } else
            throw new ResourceNotFoundException("ID " + id + " No exists this Enrollment");
    }
}
