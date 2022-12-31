package com.vaishali.basic.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.vaishali.basic.model.SubwayStaff;

public class SubwayStaffDAOImplementation implements SubwayStaffDAO{
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private SubwayStaff subwayStaffInfo;
	static
	{
		entityManagerFactory = Persistence.createEntityManagerFactory("staff");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	@Override
	public String addStaffRecord(SubwayStaff subwayStaff) {
		
		entityTransaction.begin();
		entityManager.persist(subwayStaff);
		entityTransaction.commit();	
		
		return "\n**Record Added In Table**";
	}

	@Override
	public String modifyStaffRecordForAll(SubwayStaff subwayStaff) {
		
		subwayStaffInfo = entityManager.find(SubwayStaff.class, subwayStaff.getStaffMemberId());
		entityTransaction.begin();
		subwayStaffInfo.setStaffMemberId(subwayStaff.getStaffMemberId());
		subwayStaffInfo.setStaffMemberName(subwayStaff.getStaffMemberName());
		subwayStaffInfo.setStaffMemberAddress(subwayStaff.getStaffMemberAddress());
		subwayStaffInfo.setStaffMemberEmailId(subwayStaff.getStaffMemberEmailId());
		subwayStaffInfo.setStaffMemberMobileNo(subwayStaff.getStaffMemberMobileNo());
		subwayStaffInfo.setStaffMemberSalary(subwayStaff.getStaffMemberSalary());
		entityTransaction.commit();	
		return "\n**All Record Updated In Table**";
	}

	@Override
	public String removeStaffRecord(Integer staffMemberId) {
		
		subwayStaffInfo = entityManager.find(SubwayStaff.class, staffMemberId);
		entityTransaction.begin();
		entityManager.remove(subwayStaffInfo);
		entityTransaction.commit();	
		return "\n**Record Deleted from Table**";
	}

	@Override
	public SubwayStaff findStaffRecord(Integer staffMemberId) {
		
		return entityManager.find(SubwayStaff.class, staffMemberId);
	}

	@Override
	public String modifyStaffRecordForAddress(SubwayStaff staffMemberAddress) {
		subwayStaffInfo = entityManager.find(SubwayStaff.class, staffMemberAddress.getStaffMemberId());
		entityTransaction.begin();
		subwayStaffInfo.setStaffMemberAddress(staffMemberAddress.getStaffMemberAddress());
		entityTransaction.commit();	
		return "\n**Address Updated In Table**";
	}

	@Override
	public String modifyStaffRecordForEmail(SubwayStaff staffMemberEmailId) {
		subwayStaffInfo = entityManager.find(SubwayStaff.class, staffMemberEmailId.getStaffMemberId());
		entityTransaction.begin();
		subwayStaffInfo.setStaffMemberEmailId(staffMemberEmailId.getStaffMemberEmailId());
		entityTransaction.commit();	
		return "\n**Email Updated In Table**";
	}

	@Override
	public String modifyStaffRecordForNumber(SubwayStaff staffMemberMobileNo) {
		subwayStaffInfo = entityManager.find(SubwayStaff.class, staffMemberMobileNo.getStaffMemberId());
		entityTransaction.begin();
		subwayStaffInfo.setStaffMemberMobileNo(staffMemberMobileNo.getStaffMemberMobileNo());
		entityTransaction.commit();	
		return "\n**Number Updated In Table**";
	}
}
