package com.gym.api.adapter;

import com.gym.api.application.dto.MembershipDto;
import com.gym.api.domain.model.Membership;
import org.springframework.stereotype.Component;

@Component
public class MembershipAdapter {

    public MembershipDto toDto(Membership membership) {

        MembershipDto toDto = new MembershipDto();
        toDto.setName(membership.getName());
        toDto.setDescription(membership.getDescription());
        toDto.setMonthlyPrice(membership.getMonthlyPrice());
        toDto.setStatus(membership.getStatus());
        return toDto;
    }
}
