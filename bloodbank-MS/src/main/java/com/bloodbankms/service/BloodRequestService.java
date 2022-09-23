package com.bloodbankms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bloodbankms.bo.BloodRequestBO;
import com.bloodbankms.entity.BloodRequest;

@Component
public class BloodRequestService {

	@Autowired
	BloodRequestBO bloodRequestBO;

	public BloodRequest insertBloorRequestWithDonorRegistration(BloodRequest bloodRequest) {
		return bloodRequestBO.insertBloorRequestWithDonorRegistration(bloodRequest);
	}

	public BloodRequest fetchDetailsById(int requestId) {
		return bloodRequestBO.fetchDetailsById(requestId);
	}

	public List<BloodRequest> fetchAllRequestDetails() {
		return bloodRequestBO.fetchAllRequestDetails();
	}

	public BloodRequest addBloodRequest(BloodRequest bloodRequest) {
		BloodRequest result = bloodRequestBO.addBloodRequest(bloodRequest);
		return result;
	}

}
