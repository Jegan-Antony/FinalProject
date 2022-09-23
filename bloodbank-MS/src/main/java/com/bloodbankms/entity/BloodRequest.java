package com.bloodbankms.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "Blood_Request")
@EntityListeners(AuditingEntityListener.class)
public class BloodRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int requestId;

	@Column(updatable = false)
	@CreatedDate
	@Temporal(TemporalType.DATE)
	private Date bookingDate;

	@Temporal(TemporalType.DATE)
	@Column(updatable = true)
	private Date bloodNeededDate;

	@Column(nullable = false)
	private String bloodGroup;

	@Column(nullable = false)
	private int units;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "Donor_Id", referencedColumnName = "donorId")
	private DonorRegistration donorRegistration;

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

	public DonorRegistration getDonorRegistration() {
		return donorRegistration;
	}

	public void setDonorRegistration(DonorRegistration donorRegistration) {
		this.donorRegistration = donorRegistration;
	}

	@Override
	public String toString() {
		return "BloodRequest [requestId=" + requestId + ", bookingDate=" + bookingDate + ", bloodNeededDate="
				+ bloodNeededDate + ", bloodGroup=" + bloodGroup + ", units=" + units + ", donorRegistration="
				+ donorRegistration + "]";
	}

}
