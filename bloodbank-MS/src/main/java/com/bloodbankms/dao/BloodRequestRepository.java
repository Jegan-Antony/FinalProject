package com.bloodbankms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbankms.entity.BloodRequest;

@Repository
public interface BloodRequestRepository extends JpaRepository<BloodRequest, Integer> {

}
