package com.vaishali.basic.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SubwayStaffInformation")//26
public class SubwayStaff {
	@Id
	@Column(name = "memberid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer staffMemberId;
	
	@Column(name = "membername")
	private String  staffMemberName;
	
	@Column(name = "memberaddress")
	private String staffMemberAddress;
	
	@Column(name = "memberemail")
	private String staffMemberEmailId;
	
	@Column(name = "membermobileno")
	private String staffMemberMobileNumber;
	
	@Column(name = "membersalary")
	private Double staffMemberSalary;
	
	@Column(name = "memberdateofbirth")
	@Temporal(value = TemporalType.DATE)	
	private Date dateOfBirth;
	
	@Column(name = "memberdateofjoining")
	@Temporal(value = TemporalType.DATE)	
	private Date dateOfJoining;
	

	public Integer getStaffMemberId() {
		return staffMemberId;
	}	
	public void setStaffMemberId(Integer staffMemberId) {
		this.staffMemberId = staffMemberId;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getStaffMemberName() {
		return staffMemberName;
	}
	public void setStaffMemberName(String staffMemberName) {
		this.staffMemberName = staffMemberName;
	}
	
	public String getStaffMemberAddress() {
		return staffMemberAddress;
	}
	public void setStaffMemberAddress(String staffMemberAddress) {
		this.staffMemberAddress = staffMemberAddress;
	}
	
	public String getStaffMemberEmailId() {
		return staffMemberEmailId;
	}
	public void setStaffMemberEmailId(String staffMemberEmailId) {
		this.staffMemberEmailId = staffMemberEmailId;
	}
	
	public String getStaffMemberMobileNo() {
		return staffMemberMobileNumber;
	}
	public void setStaffMemberMobileNo(String staffMemberMobileNo) {
		this.staffMemberMobileNumber = staffMemberMobileNo;
	}
	
	public Double getStaffMemberSalary() {
		return staffMemberSalary;
	}
	public void setStaffMemberSalary(Double staffMemberSalary) {
		this.staffMemberSalary = staffMemberSalary;
	}
}
