package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.exception.InvalidMembershipException;
import com.model.Membership;
import com.service.IMembershipService;

@RestController
@RequestMapping("/")
public class MembershipController {

    @Autowired
    private IMembershipService membershipService;

    @PostMapping("/addMembership")
    public ResponseEntity<Membership> addMembership(@Validated @RequestBody Membership membership) {
        return new ResponseEntity<>(membershipService.addMembership(membership), HttpStatus.OK);
    }

    @GetMapping("/viewMembershipById/{membershipId}")
    public ResponseEntity<Membership> viewMembershipById(@PathVariable String membershipId) throws InvalidMembershipException {
        return new ResponseEntity<>(membershipService.viewMembershipById(membershipId), HttpStatus.OK);
    }

    @GetMapping("/viewMembershipsByBenefit/{benefit}")
    public ResponseEntity<List<Membership>> viewMembershipsByBenefit(@PathVariable String benefit) {
        return new ResponseEntity<>(membershipService.viewMembershipsByBenefit(benefit), HttpStatus.OK);
    }

    @GetMapping("/viewMembershipsByTypeAndAccessHours/{membershipType}/{monthlyAccessHours}")
    public ResponseEntity<List<Membership>> viewMembershipsByTypeAndAccessHours(@PathVariable String membershipType, @PathVariable int monthlyAccessHours) {
        return new ResponseEntity<>(membershipService.viewMembershipsByTypeAndAccessHours(membershipType, monthlyAccessHours), HttpStatus.OK);
    }

    @GetMapping("/getMembershipCountTypeWise")
    public ResponseEntity<Map<String, Integer>> getMembershipCountTypeWise() {
        return new ResponseEntity<>(membershipService.getMembershipCountTypeWise(), HttpStatus.OK);
    }
}
