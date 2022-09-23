package com.bloodbankms.bo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bloodbankms.dao.DonorRegistrationRepository;
import com.bloodbankms.dao.IDonorJoinProjection;
import com.bloodbankms.dao.IDonorRegistrationCustomized;
import com.bloodbankms.entity.DonorRegistration;
import com.bloodbankms.dao.IDonorRegistrationProjection;

@Component
public class DonorRegistrationBO {

	@Autowired
	DonorRegistrationRepository donorRegistrationRepository;

	public DonorRegistration insertDonorDetails(DonorRegistration donorRegistration) {
		DonorRegistration result = donorRegistrationRepository.save(donorRegistration);
		return result;
	}

	public DonorRegistration fetchDonorDetailsByDonorId(int donorId) {
		Optional<DonorRegistration> list = donorRegistrationRepository.findById(donorId);
		return list.get();
	}

	public List<DonorRegistration> fetchAllDonorDetails() {
		return donorRegistrationRepository.findAll();
	}

	public DonorRegistration updateDonorDetails(int donorId, DonorRegistration donorRegistration) {
		DonorRegistration result = donorRegistrationRepository.save(donorRegistration);
		return result;
	}

	public void deleteDonor(int donorId) {
		donorRegistrationRepository.deleteById(donorId);

	}

	public List<DonorRegistration> viewDonorById(int donorId) {
		return donorRegistrationRepository.viewDonorById(donorId);
	}

	public List<DonorRegistration> searchDonorByStartingLetter(char startingLetter) {
		return donorRegistrationRepository.searchDonorByStartingLetter(startingLetter);
	}

	public List<DonorRegistration> viewDonorsGroupByGender() {
		return donorRegistrationRepository.viewDonorsGroupByGender();
	}

	public List<DonorRegistration> viewAllDonorInDecending() {
		return donorRegistrationRepository.viewAllDonorInDecending();
	}

	public List<DonorRegistration> viewDonorJoinRequest() {
		return donorRegistrationRepository.viewDonorJoinRequest();
	}

	public List<IDonorRegistrationCustomized> findCustomizedDonorByName(String donorName1) {
		return donorRegistrationRepository.findCustomizedDonorByName(donorName1);
	}

	public List<IDonorRegistrationProjection> findAllDonorByProjection() {
		return donorRegistrationRepository.findAllDonorByProjection();
	}

	public List<IDonorJoinProjection> viewAllDonorWithRequest() {
		return donorRegistrationRepository.viewAllDonorWithRequest();
	}

}
