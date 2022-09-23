package com.bloodbankms.dto;

import java.util.Date;

public class BloodRequestDto {

	private int requestId;
	private Date bookingDate;
	private Date bloodNeededDate;
	private String bloodGroup;
	private int units;
	private DonorRegistrationDto donorRegistrationDto;

	public DonorRegistrationDto getDonorRegistrationDto() {
		return donorRegistrationDto;
	}

	public void setDonorRegistrationDto(DonorRegistrationDto donorRegistrationDto) {
		this.donorRegistrationDto = donorRegistrationDto;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getBloodNeededDate() {
		return bloodNeededDate;
	}

	public void setBloodNeededDate(Date bloodNeededDate) {
		this.bloodNeededDate = bloodNeededDate;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

}
