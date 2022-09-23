package com.bloodbankms.bo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bloodbankms.dao.BloodRequestRepository;
import com.bloodbankms.entity.BloodRequest;

@Component
public class BloodRequestBO {

	@Autowired
	BloodRequestRepository bloodRequestRepository;

	public BloodRequest insertBloorRequestWithDonorRegistration(BloodRequest bloodRequest) {
		BloodRequest result = bloodRequestRepository.save(bloodRequest);
		return result;
	}

	public BloodRequest fetchDetailsById(int requestId) {
		Optional<BloodRequest> list = bloodRequestRepository.findById(requestId);
		return list.get();
	}

	public List<BloodRequest> fetchAllRequestDetails() {
		return bloodRequestRepository.findAll();
	}

	public BloodRequest addBloodRequest(BloodRequest bloodRequest) {
		BloodRequest result = bloodRequestRepository.save(bloodRequest);
		return result;
	}

}
