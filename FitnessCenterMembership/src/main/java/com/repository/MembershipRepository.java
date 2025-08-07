package com.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Membership;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, String> {

    List<Membership> findByBenefitsContaining(String benefit);

    List<Membership> findByMembershipTypeAndMonthlyAccessHoursGreaterThan(String membershipType, int hours);

    @Query("SELECT m.membershipType AS type, COUNT(m) AS count FROM Membership m GROUP BY m.membershipType")
    List<Map<String, Object>> getCountByMembershipType();
}
