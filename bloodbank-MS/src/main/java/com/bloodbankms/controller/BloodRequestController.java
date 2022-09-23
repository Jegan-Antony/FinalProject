package com.bloodbankms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bloodbankms.dto.BloodRequestDto;
import com.bloodbankms.dto.DonorRegistrationDto;
import com.bloodbankms.entity.BloodRequest;
import com.bloodbankms.entity.DonorRegistration;
import com.bloodbankms.service.BloodRequestService;
import com.bloodbankms.service.DonorRegistrationService;

@RestController
public class BloodRequestController {

	@Autowired
	BloodRequestService bloodRequestService;

	@Autowired
	DonorRegistrationService donorRegistrationService;

	@PostMapping("/insertBloodRequestWithDonorRegistration")
	public String insertBloorRequestWithDonorRegistration(@RequestBody BloodRequestDto bloodRequestDto) {
		BloodRequest bloodRequestEntity = new BloodRequest();
		DonorRegistration donorRegistrationEntity = new DonorRegistration();
		bloodRequestEntity.setBloodNeededDate(bloodRequestDto.getBloodNeededDate());
		bloodRequestEntity.setBloodGroup(bloodRequestDto.getBloodGroup());
		bloodRequestEntity.setUnits(bloodRequestDto.getUnits());

		DonorRegistrationDto donorRegistrationDto = bloodRequestDto.getDonorRegistrationDto();

		donorRegistrationEntity.setDonorName(donorRegistrationDto.getDonorName());
		donorRegistrationEntity.setDateOfBirth(donorRegistrationDto.getDateOfBirth());
		donorRegistrationEntity.setGender(donorRegistrationDto.getGender());
		donorRegistrationEntity.setAddress(donorRegistrationDto.getAddress());
		donorRegistrationEntity.setPincode(donorRegistrationDto.getPincode());
		donorRegistrationEntity.setBloodGroup(donorRegistrationDto.getBloodGroup());
		donorRegistrationEntity.setContactNumber(donorRegistrationDto.getContactNumber());
		bloodRequestEntity.setDonorRegistration(donorRegistrationEntity);
		bloodRequestService.insertBloorRequestWithDonorRegistration(bloodRequestEntity);
		String result = "Record inserted successfully";
		return result;
	}

	@GetMapping("/fetchDetailsById")
	public BloodRequestDto fetchDetailsById(@RequestParam("requestId") int requestId) {
		BloodRequest bloodRequestEntity = bloodRequestService.fetchDetailsById(requestId);
		BloodRequestDto bloodRequestDto = new BloodRequestDto();
		bloodRequestDto.setRequestId(bloodRequestEntity.getRequestId());
		bloodRequestDto.setBookingDate(bloodRequestEntity.getBookingDate());
		bloodRequestDto.setBloodNeededDate(bloodRequestEntity.getBloodNeededDate());
		bloodRequestDto.setBloodGroup(bloodRequestEntity.getBloodGroup());
		bloodRequestDto.setUnits(bloodRequestEntity.getUnits());
		DonorRegistration donorRegistration = bloodRequestEntity.getDonorRegistration();
		DonorRegistrationDto donorRegistrationDto = new DonorRegistrationDto();
		donorRegistrationDto.setDonorId(donorRegistration.getDonorId());
		donorRegistrationDto.setDonorName(donorRegistration.getDonorName());
		donorRegistrationDto.setDateOfBirth(donorRegistration.getDateOfBirth());
		donorRegistrationDto.setGender(donorRegistration.getGender());
		donorRegistrationDto.setAddress(donorRegistration.getAddress());
		donorRegistrationDto.setPincode(donorRegistration.getPincode());
		donorRegistrationDto.setBloodGroup(donorRegistration.getBloodGroup());
		donorRegistrationDto.setContactNumber(donorRegistration.getContactNumber());
		donorRegistrationDto.setRegisteredDate(donorRegistration.getRegisteredDate());
		bloodRequestDto.setDonorRegistrationDto(donorRegistrationDto);
		return bloodRequestDto;
	}

	@GetMapping("/fetchAllRequestDetails")
	public List<BloodRequestDto> fetchAllRequestDetails() {
		List<BloodRequest> entitylist = bloodRequestService.fetchAllRequestDetails();
		List<BloodRequestDto> list = new ArrayList<>();
		for (BloodRequest iteration : entitylist) {
			BloodRequestDto bloodRequestDto = new BloodRequestDto();
			DonorRegistrationDto donorRegistrationDto = new DonorRegistrationDto();
			bloodRequestDto.setRequestId(iteration.getRequestId());
			bloodRequestDto.setBookingDate(iteration.getBookingDate());
			bloodRequestDto.setBloodNeededDate(iteration.getBookingDate());
			bloodRequestDto.setBloodGroup(iteration.getBloodGroup());
			bloodRequestDto.setUnits(iteration.getUnits());
			bloodRequestDto.setUnits(iteration.getDonorRegistration().getDonorId());
			donorRegistrationDto.setDonorId(iteration.getDonorRegistration().getDonorId());
			donorRegistrationDto.setDonorName(iteration.getDonorRegistration().getDonorName());
			donorRegistrationDto.setDateOfBirth(iteration.getDonorRegistration().getDateOfBirth());
			donorRegistrationDto.setGender(iteration.getDonorRegistration().getGender());
			donorRegistrationDto.setAddress(iteration.getDonorRegistration().getAddress());
			donorRegistrationDto.setPincode(iteration.getDonorRegistration().getPincode());
			donorRegistrationDto.setContactNumber(iteration.getDonorRegistration().getContactNumber());
			donorRegistrationDto.setBloodGroup(iteration.getDonorRegistration().getBloodGroup());
			donorRegistrationDto.setRegisteredDate(iteration.getDonorRegistration().getRegisteredDate());
			bloodRequestDto.setDonorRegistrationDto(donorRegistrationDto);
			list.add(bloodRequestDto);
		}
		return list;
	}

	@PostMapping("/addBloodRequest")
	public String addBloodRequest(@RequestBody BloodRequest bloodRequest) {
		String result = "Blood Request Submitted Successfully";
		DonorRegistration donorRegistration = donorRegistrationService
				.fetchDonorDetailsByDonorId(bloodRequest.getDonorRegistration().getDonorId());
		BloodRequest bloodRequestEntity = new BloodRequest();
		bloodRequestEntity.setBloodNeededDate(bloodRequest.getBloodNeededDate());
		bloodRequestEntity.setBloodGroup(bloodRequest.getBloodGroup());
		bloodRequestEntity.setUnits(bloodRequest.getUnits());
		bloodRequest.setDonorRegistration(donorRegistration);
		bloodRequestService.addBloodRequest(bloodRequest);
		return result;
	}

}
