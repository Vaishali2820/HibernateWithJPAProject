package com.vaishali.basic.dao;
import com.vaishali.basic.model.SubwayStaff;

public interface SubwayStaffDAO {
	public String addStaffRecord(SubwayStaff subwayStaff);
	public String modifyStaffRecordForAll(SubwayStaff subwayStaff);
	public String modifyStaffRecordForAddress(SubwayStaff staffMemberAddress);
	public String modifyStaffRecordForEmail(SubwayStaff staffMemberEmailId);
	public String modifyStaffRecordForNumber(SubwayStaff staffMemberMobileNumber);
	public String removeStaffRecord(Integer staffMemberId);
	public SubwayStaff findStaffRecord(Integer staffMemberId);
}
