package com.gym.api.infra.feign;

import com.gym.api.application.dto.MembershipDto;
import com.gym.api.domain.model.Membership;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("membership-service")
public interface MembershipClient {
    @GetMapping("/memberships/{id}")
    MembershipDto getAllDetailsMembershipById(@PathVariable("id") Long id);

}





