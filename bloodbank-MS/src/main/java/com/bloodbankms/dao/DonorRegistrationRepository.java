package com.bloodbankms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bloodbankms.entity.DonorRegistration;

@Repository
public interface DonorRegistrationRepository extends JpaRepository<DonorRegistration, Integer> {

	@Query("select r from DonorRegistration r where r.donorId> :donorId")
	List<DonorRegistration> viewDonorById(@Param("donorId") int donorId);

	@Query("select r from DonorRegistration r where r.donorName LIKE :startingLetter%")
	List<DonorRegistration> searchDonorByStartingLetter(@Param("startingLetter") char startingLetter);

//	 customized Query Projection
	@Query("select r.donorName as donorName,r.bloodGroup as bloodGroup from DonorRegistration r where r.donorName=:donorName1")
	List<IDonorRegistrationCustomized> findCustomizedDonorByName(@Param("donorName1") String donorName);

//	Named Query
	List<DonorRegistration> viewDonorsGroupByGender();

	List<DonorRegistration> viewAllDonorInDecending();

//	Join Query
	@Query("select r from DonorRegistration r JOIN BloodRequest b on r.donorId=b.donorRegistration")
	List<DonorRegistration> viewDonorJoinRequest();

	// Projection
	@Query("select r.donorName as donorName,r.bloodGroup as bloodGroup,r.address as address from DonorRegistration r")
	List<IDonorRegistrationProjection> findAllDonorByProjection();

	// Projection Join
	@Query("select r.donorName as donorName,r.contactNumber as contactNumber,b.bloodNeededDate as bloodNeededDate,b.bloodGroup as bloodGroup from DonorRegistration r right join BloodRequest b on r.donorId=b.donorRegistration")
	List<IDonorJoinProjection> viewAllDonorWithRequest();
}
