package com.bloodbankms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bloodbankms.bo.BloodRequestBO;
import com.bloodbankms.bo.DonorRegistrationBO;
import com.bloodbankms.dao.IDonorJoinProjection;
import com.bloodbankms.dao.IDonorRegistrationCustomized;
import com.bloodbankms.dao.IDonorRegistrationProjection;
import com.bloodbankms.entity.BloodRequest;
import com.bloodbankms.entity.DonorRegistration;

@Component
public class DonorRegistrationService {

	@Autowired
	DonorRegistrationBO donorRegistrationBO;

	@Autowired
	BloodRequestBO bloodRequestBO;

	public DonorRegistration insertDonorDetails(DonorRegistration donorRegistration) {
		return donorRegistrationBO.insertDonorDetails(donorRegistration);
	}

	public DonorRegistration fetchDonorDetailsByDonorId(int donorId) {
		return donorRegistrationBO.fetchDonorDetailsByDonorId(donorId);
	}

	public List<DonorRegistration> fetchAllDonorDetails() {
		return donorRegistrationBO.fetchAllDonorDetails();
	}

	public DonorRegistration updateDonorDetails(int donorId, DonorRegistration donorRegistration) {
		DonorRegistration result = donorRegistrationBO.updateDonorDetails(donorId, donorRegistration);
		return result;
	}

	public void deleteDonor(int donorId) {
		donorRegistrationBO.deleteDonor(donorId);
	}

	public List<DonorRegistration> viewDonorById(int donorId) {
		return donorRegistrationBO.viewDonorById(donorId);
	}

	public List<DonorRegistration> searchDonorByStartingLetter(char startingLetter) {
		return donorRegistrationBO.searchDonorByStartingLetter(startingLetter);
	}

	public List<DonorRegistration> viewDonorsGroupByGender() {
		return donorRegistrationBO.viewDonorsGroupByGender();
	}

	public List<DonorRegistration> viewAllDonorInDecending() {
		return donorRegistrationBO.viewAllDonorInDecending();
	}

	public List<DonorRegistration> viewDonorJoinRequest() {
		return donorRegistrationBO.viewDonorJoinRequest();
	}

	public List<IDonorRegistrationCustomized> findCustomizedDonorByName(String donorName1) {
		return donorRegistrationBO.findCustomizedDonorByName(donorName1);
	}

	public List<IDonorRegistrationProjection> findAllDonorByProjection() {
		return donorRegistrationBO.findAllDonorByProjection();
	}

	public List<IDonorJoinProjection> viewAllDonorWithRequest() {
		return donorRegistrationBO.viewAllDonorWithRequest();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void insertRecordsUsingTransactional(DonorRegistration donorRegistration, BloodRequest bloodRequest) {
		donorRegistrationBO.insertDonorDetails(donorRegistration);
		bloodRequestBO.addBloodRequest(bloodRequest);
	}
}