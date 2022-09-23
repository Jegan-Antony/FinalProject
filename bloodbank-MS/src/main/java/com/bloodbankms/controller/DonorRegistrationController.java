package com.bloodbankms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bloodbankms.dao.IDonorJoinProjection;
import com.bloodbankms.dao.IDonorRegistrationCustomized;
import com.bloodbankms.dto.DonorRegistrationDto;
import com.bloodbankms.entity.BloodRequest;
import com.bloodbankms.entity.DonorRegistration;
import com.bloodbankms.service.DonorRegistrationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DonorRegistrationController {

	@Autowired
	DonorRegistrationService donorRegistrationService;

	@PostMapping("/insertDonorDetails")
	public DonorRegistration insertDonorDetails(@RequestBody DonorRegistrationDto donorRegistrationDto) {
		DonorRegistration donorRegistrationEntity = new DonorRegistration();
		donorRegistrationEntity.setDonorName(donorRegistrationDto.getDonorName());
		donorRegistrationEntity.setDateOfBirth(donorRegistrationDto.getDateOfBirth());
		donorRegistrationEntity.setGender(donorRegistrationDto.getGender());
		donorRegistrationEntity.setAddress(donorRegistrationDto.getAddress());
		donorRegistrationEntity.setPincode(donorRegistrationDto.getPincode());
		donorRegistrationEntity.setBloodGroup(donorRegistrationDto.getBloodGroup());
		donorRegistrationEntity.setContactNumber(donorRegistrationDto.getContactNumber());
		donorRegistrationService.insertDonorDetails(donorRegistrationEntity);

		return donorRegistrationEntity;
	}

	@PostMapping("/insertDonorDetailsAndRequest")
	public String insertDonorDetailsAndRequest(@RequestBody DonorRegistration donorRegistration) {

		List<BloodRequest> requestList = donorRegistration.getBloodRequest();
		List<BloodRequest> list = new ArrayList<>();
		for (BloodRequest addList : requestList) {
			BloodRequest bloodRequest = new BloodRequest();
			bloodRequest.setBloodNeededDate(addList.getBloodNeededDate());
			bloodRequest.setBloodGroup(addList.getBloodGroup());
			bloodRequest.setUnits(addList.getUnits());
			bloodRequest.setDonorRegistration(donorRegistration);
			list.add(bloodRequest);
		}
		donorRegistration.setBloodRequest(list);
		donorRegistrationService.insertDonorDetails(donorRegistration);
		String result = "Record inserted successfully";
		return result;
	}

	@GetMapping("/fetchDonorDetailsByDonorId")
	public DonorRegistrationDto fetchDonorDetailsByDonorId(@RequestParam int donorId) {
		DonorRegistration donorRegistrationEntity = donorRegistrationService.fetchDonorDetailsByDonorId(donorId);
		DonorRegistrationDto donorRegistrationDto = new DonorRegistrationDto();
		donorRegistrationDto.setDonorId(donorRegistrationEntity.getDonorId());
		donorRegistrationDto.setDonorName(donorRegistrationEntity.getDonorName());
		donorRegistrationDto.setDateOfBirth(donorRegistrationEntity.getDateOfBirth());
		donorRegistrationDto.setGender(donorRegistrationEntity.getGender());
		donorRegistrationDto.setAddress(donorRegistrationEntity.getAddress());
		donorRegistrationDto.setPincode(donorRegistrationEntity.getPincode());
		donorRegistrationDto.setBloodGroup(donorRegistrationEntity.getBloodGroup());
		donorRegistrationDto.setContactNumber(donorRegistrationEntity.getContactNumber());
		donorRegistrationDto.setRegisteredDate(donorRegistrationEntity.getRegisteredDate());
		return donorRegistrationDto;
	}

	@GetMapping("/fetchAllDonorDetails")
	public List<DonorRegistrationDto> fetchAllDonorDetails() {
		List<DonorRegistration> donorList = donorRegistrationService.fetchAllDonorDetails();
		List<DonorRegistrationDto> dtoList = new ArrayList<>();
		for (DonorRegistration list : donorList) {
			DonorRegistrationDto donorRegistrationDto = new DonorRegistrationDto();
			donorRegistrationDto.setDonorId(list.getDonorId());
			donorRegistrationDto.setDonorName(list.getDonorName());
			donorRegistrationDto.setDateOfBirth(list.getDateOfBirth());
			donorRegistrationDto.setGender(list.getGender());
			donorRegistrationDto.setAddress(list.getAddress());
			donorRegistrationDto.setPincode(list.getPincode());
			donorRegistrationDto.setBloodGroup(list.getBloodGroup());
			donorRegistrationDto.setContactNumber(list.getContactNumber());
			donorRegistrationDto.setRegisteredDate(list.getRegisteredDate());
			dtoList.add(donorRegistrationDto);
		}
		return dtoList;
	}

	@RequestMapping(value = "/updateDonorDetails", method = RequestMethod.PUT)
	public DonorRegistration updateDonorDetails(@RequestParam("donorId") int donorId,
			@RequestBody DonorRegistrationDto donorRegistrationDto) {

		DonorRegistration donorRegistration = donorRegistrationService.fetchDonorDetailsByDonorId(donorId);
		donorRegistration.setDonorName(donorRegistrationDto.getDonorName());
		donorRegistration.setDateOfBirth(donorRegistrationDto.getDateOfBirth());
		donorRegistration.setGender(donorRegistrationDto.getGender());
		donorRegistration.setAddress(donorRegistrationDto.getAddress());
		donorRegistration.setPincode(donorRegistrationDto.getPincode());
		donorRegistration.setBloodGroup(donorRegistrationDto.getBloodGroup());
		donorRegistration.setContactNumber(donorRegistrationDto.getContactNumber());
		donorRegistrationService.insertDonorDetails(donorRegistration);
		return donorRegistration;
	}

	@DeleteMapping("/deleteDonorByDonorId/{donorId}")
	public void deleteDonor(@PathVariable int donorId) {

		donorRegistrationService.deleteDonor(donorId);
	}

	// Normal Query
	@GetMapping("/viewDonorDonorIdIsGraterthanCondition")
	public List<DonorRegistrationDto> viewDonorById(@RequestParam("donorId") int donorId) {
		List<DonorRegistration> donorList = donorRegistrationService.viewDonorById(donorId);
		List<DonorRegistrationDto> dtoList = new ArrayList<>();
		for (DonorRegistration list : donorList) {
			DonorRegistrationDto donorRegistrationDto = new DonorRegistrationDto();
			donorRegistrationDto.setDonorId(list.getDonorId());
			donorRegistrationDto.setDonorName(list.getDonorName());
			donorRegistrationDto.setDateOfBirth(list.getDateOfBirth());
			donorRegistrationDto.setGender(list.getGender());
			donorRegistrationDto.setAddress(list.getAddress());
			donorRegistrationDto.setPincode(list.getPincode());
			donorRegistrationDto.setBloodGroup(list.getBloodGroup());
			donorRegistrationDto.setContactNumber(list.getContactNumber());
			donorRegistrationDto.setRegisteredDate(list.getRegisteredDate());
			dtoList.add(donorRegistrationDto);
		}
		return dtoList;
	}

	// Normal Query
	@GetMapping("/searchDonorByStartingLetter")
	public List<DonorRegistrationDto> searchDonorByStartingLetter(@RequestParam("startingLetter") char startingLetter) {
		List<DonorRegistration> donorList = donorRegistrationService.searchDonorByStartingLetter(startingLetter);
		List<DonorRegistrationDto> dtoList = new ArrayList<>();
		for (DonorRegistration list : donorList) {
			DonorRegistrationDto donorRegistrationDto = new DonorRegistrationDto();
			donorRegistrationDto.setDonorId(list.getDonorId());
			donorRegistrationDto.setDonorName(list.getDonorName());
			donorRegistrationDto.setDateOfBirth(list.getDateOfBirth());
			donorRegistrationDto.setGender(list.getGender());
			donorRegistrationDto.setAddress(list.getAddress());
			donorRegistrationDto.setPincode(list.getPincode());
			donorRegistrationDto.setBloodGroup(list.getBloodGroup());
			donorRegistrationDto.setContactNumber(list.getContactNumber());
			donorRegistrationDto.setRegisteredDate(list.getRegisteredDate());
			dtoList.add(donorRegistrationDto);
		}
		return dtoList;
	}

	// Named Query
	@GetMapping("/viewDonorsGroupByGender")
	public List<DonorRegistrationDto> viewDonorsGroupByGender() {
		List<DonorRegistration> donorList = donorRegistrationService.viewDonorsGroupByGender();
		List<DonorRegistrationDto> dtoList = new ArrayList<>();
		for (DonorRegistration list : donorList) {
			DonorRegistrationDto donorRegistrationDto = new DonorRegistrationDto();
			donorRegistrationDto.setDonorId(list.getDonorId());
			donorRegistrationDto.setDonorName(list.getDonorName());
			donorRegistrationDto.setDateOfBirth(list.getDateOfBirth());
			donorRegistrationDto.setGender(list.getGender());
			donorRegistrationDto.setAddress(list.getAddress());
			donorRegistrationDto.setPincode(list.getPincode());
			donorRegistrationDto.setBloodGroup(list.getBloodGroup());
			donorRegistrationDto.setContactNumber(list.getContactNumber());
			donorRegistrationDto.setRegisteredDate(list.getRegisteredDate());
			dtoList.add(donorRegistrationDto);
		}
		return dtoList;
	}

	// Named Query
	@GetMapping("/viewAllDonorInDecending")
	public List<DonorRegistrationDto> viewAllDonorInDecending() {
		List<DonorRegistration> donorList = donorRegistrationService.viewAllDonorInDecending();
		List<DonorRegistrationDto> dtoList = new ArrayList<>();
		for (DonorRegistration list : donorList) {
			DonorRegistrationDto donorRegistrationDto = new DonorRegistrationDto();
			donorRegistrationDto.setDonorId(list.getDonorId());
			donorRegistrationDto.setDonorName(list.getDonorName());
			donorRegistrationDto.setDateOfBirth(list.getDateOfBirth());
			donorRegistrationDto.setGender(list.getGender());
			donorRegistrationDto.setAddress(list.getAddress());
			donorRegistrationDto.setPincode(list.getPincode());
			donorRegistrationDto.setBloodGroup(list.getBloodGroup());
			donorRegistrationDto.setContactNumber(list.getContactNumber());
			donorRegistrationDto.setRegisteredDate(list.getRegisteredDate());
			dtoList.add(donorRegistrationDto);
		}
		return dtoList;
	}

	// Normal Join Query
	@GetMapping("/viewDonorJoinRequest")
	public List<DonorRegistrationDto> viewDonorJoinRequest() {
		List<DonorRegistration> donorList = donorRegistrationService.viewDonorJoinRequest();
		List<DonorRegistrationDto> dtoList = new ArrayList<>();
		for (DonorRegistration list : donorList) {
			DonorRegistrationDto donorRegistrationDto = new DonorRegistrationDto();
			donorRegistrationDto.setDonorId(list.getDonorId());
			donorRegistrationDto.setDonorName(list.getDonorName());
			donorRegistrationDto.setDateOfBirth(list.getDateOfBirth());
			donorRegistrationDto.setGender(list.getGender());
			donorRegistrationDto.setAddress(list.getAddress());
			donorRegistrationDto.setPincode(list.getPincode());
			donorRegistrationDto.setBloodGroup(list.getBloodGroup());
			donorRegistrationDto.setContactNumber(list.getContactNumber());
			donorRegistrationDto.setRegisteredDate(list.getRegisteredDate());
			dtoList.add(donorRegistrationDto);
		}
		return dtoList;
	}

	// Customized Query using Projection
	@GetMapping("/findCustomizedDonorByName")
	public List<IDonorRegistrationCustomized> findCustomizedDonorByName(@RequestParam("donorName") String donorName) {
		List<IDonorRegistrationCustomized> donorList = donorRegistrationService.findCustomizedDonorByName(donorName);

		return donorList;
	}

	// Customized Query using Projection
	@GetMapping("/viewAllDonorWithRequest")
	public List<IDonorJoinProjection> viewAllDonorWithRequest() {
		return donorRegistrationService.viewAllDonorWithRequest();
	}
}