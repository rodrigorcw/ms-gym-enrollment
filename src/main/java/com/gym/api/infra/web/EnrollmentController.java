package com.gym.api.infra.web;

import com.gym.api.adapter.EnrollmentAdapter;
import com.gym.api.adapter.MembershipAdapter;
import com.gym.api.application.dto.EnrollmentDTO;
import com.gym.api.domain.enums.StatusEnum;
import com.gym.api.domain.model.Enrollment;
import com.gym.api.domain.service.EnrollmentService;
import com.gym.api.infra.feign.MembershipClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;
    @Autowired
    private MembershipClient membershipClient;
    @Autowired
    private EnrollmentAdapter enrollmentAdapter;
    @Autowired
    private MembershipAdapter membershipAdapter;

    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> findAll() {
        return ResponseEntity.ok(enrollmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> getEnrollmentById(@PathVariable Long id) {
        return ResponseEntity.ok(enrollmentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EnrollmentDTO> createEnrollment(@RequestBody Enrollment enrollment) {
        return ResponseEntity.ok(enrollmentService.createEnrollment(enrollment));
    }

    @PutMapping("/{id}/activate")
    public ResponseEntity activateEnrollment(@PathVariable Long id) {
        enrollmentService.updateStatus(id, StatusEnum.ACTIVE);
        return ResponseEntity.ok("This Membership is Activate");
    }

    @PutMapping("/{id}/inactivate")
    public ResponseEntity inactivateEnrollment(@PathVariable Long id) {
        enrollmentService.updateStatus(id, StatusEnum.CANCELED);
        return ResponseEntity.ok("This Membership is Inactivate");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id, StatusEnum status) {
        enrollmentService.deleteById(id, StatusEnum.CANCELED);
        return ResponseEntity.ok("Enrollment removed");
    }
}
