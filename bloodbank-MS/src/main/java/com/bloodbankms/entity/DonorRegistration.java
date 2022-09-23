package com.bloodbankms.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "Donor_Registration")
@EntityListeners(AuditingEntityListener.class)
@NamedQuery(name = "DonorRegistration.viewDonorsGroupByGender", query = "select r from DonorRegistration r GROUP  BY r.gender")
@NamedQueries({
		@NamedQuery(name = "DonorRegistration.viewAllDonorInDecending", query = "select r from DonorRegistration r ORDER BY r.donorId DESC") })
public class DonorRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int donorId;

	private String donorName;

	@Column(nullable = false)
	private String gender;

	@Column(nullable = false, updatable = true)
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	private String address;

	private int pincode;

	@Column(unique = true)
	private long contactNumber;

	@Column(updatable = false, nullable = false)
	private String bloodGroup;

	@Column(name = "Registered_Date", updatable = false)
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date registeredDate;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "donorRegistration")
	private List<BloodRequest> bloodRequest;

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public List<BloodRequest> getBloodRequest() {
		return bloodRequest;
	}

	public void setBloodRequest(List<BloodRequest> bloodRequest) {
		this.bloodRequest = bloodRequest;
	}

	@Override
	public String toString() {
		return "DonorRegistration [donorId=" + donorId + ", donorName=" + donorName + ", gender=" + gender
				+ ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", pincode=" + pincode + ", contactNumber="
				+ contactNumber + ", bloodGroup=" + bloodGroup + ", registeredDate=" + registeredDate
				+ ", bloodRequest=" + bloodRequest + "]";
	}

}
