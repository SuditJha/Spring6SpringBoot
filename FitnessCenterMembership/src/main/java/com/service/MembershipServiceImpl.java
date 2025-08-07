package com.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.InvalidMembershipException;
import com.model.Membership;
import com.repository.MembershipRepository;

@Service
public class MembershipServiceImpl implements IMembershipService {

    @Autowired
    private MembershipRepository membershipRepo;

    @Override
    public Membership addMembership(Membership membership) {
        return membershipRepo.save(membership);
    }

    @Override
    public Membership viewMembershipById(String membershipId) throws InvalidMembershipException {
        return membershipRepo.findById(membershipId)
                .orElseThrow(() -> new InvalidMembershipException("Membership not found for ID: " + membershipId));
    }

    @Override
    public List<Membership> viewMembershipsByBenefit(String benefit) {
        return membershipRepo.findByBenefitsContaining(benefit);
    }

    @Override
    public List<Membership> viewMembershipsByTypeAndAccessHours(String membershipType, int hours) {
        return membershipRepo.findByMembershipTypeAndMonthlyAccessHoursGreaterThan(membershipType, hours);
    }

    @Override
    public Map<String, Integer> getMembershipCountTypeWise() {
        List<Map<String, Object>> rawData = membershipRepo.getCountByMembershipType();
        return rawData.stream()
                .collect(Collectors.toMap(
                    e -> (String) e.get("type"),
                    e -> ((Number) e.get("count")).intValue()
                ));
    }
}
