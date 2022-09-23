package com.bloodbankms.dao;

import java.util.Date;

public interface IDonorJoinProjection {

	public String getDonorName();

	public long getContactNumber();

	public Date getBloodNeededDate();

	public String getBloodGroup();
}
