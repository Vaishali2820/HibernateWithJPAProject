package com.vaishali.basic.presentation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import com.vaishali.basic.dao.SubwayStaffDAO;
import com.vaishali.basic.dao.SubwayStaffDAOImplementation;
import com.vaishali.basic.exception.CheckCustomerIdException;
import com.vaishali.basic.model.SubwayStaff;
import com.vaishali.basic.validetion.Validations;

public class UserInterfaceImplementation implements UserInterface {
	
	private Scanner scanner = new Scanner(System.in);
	private SubwayStaffDAO subwayStaffDAO = new SubwayStaffDAOImplementation();
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");	
	private SubwayStaff subwayStaff2;
	private SubwayStaff subwayStaff1 = new SubwayStaff();
	private Date date, date1;
	private Integer staffMemberId;
	private String  staffMemberName;
	private String staffMemberAddress;
	private String staffMemberEmailId;
	private String staffMemberMobileNumber;
	private Double staffMemberSalary;
	private String dob;
	private String doj;
	private Boolean checkingName;
	private Boolean checkingEmail;
	private Boolean checkingMobileNo;
	private Boolean checkingSalary;
	private Boolean checkingDateOfBirth;
	private Boolean checkingDateOfJoining;

	@Override
	public void addStaffRecord()  {
		SubwayStaff subwayStaff = new SubwayStaff();
		checkingName = true;
		checkingEmail = true;
		checkingMobileNo = true;
		checkingSalary = true;
		checkingDateOfBirth = true;
		checkingDateOfJoining = true;
		while(checkingName)
		{
			System.out.print("\nEnter the Staff Member Name:");
			staffMemberName = scanner.next();
			if(Validations.checkNameLength(staffMemberName))
			{
				if(Validations.checkValidName(staffMemberName))
				{
					subwayStaff.setStaffMemberName(staffMemberName);
					checkingName = false;
				}
				else
				{
					System.out.print("\n-----------------------------");
					System.out.println("\nInvalid Name Format...");
					System.out.print("-----------------------------\n");
				}
			}
			else
			{
				System.out.print("\n----------------------------------------");
				System.out.println("\nName length should be Less Then 15...");
				System.out.print("----------------------------------------\n");
			}
		}
		System.out.print("Enter the Staff Member Address:");
		staffMemberAddress = scanner.next();
		subwayStaff.setStaffMemberAddress(staffMemberAddress);
		while(checkingEmail)
		{
			System.out.print("Enter the Staff Member Email:");
			staffMemberEmailId = scanner.next();
			if(Validations.checkEmail(staffMemberEmailId))
			{
				subwayStaff.setStaffMemberEmailId(staffMemberEmailId);
				checkingEmail = false;
				while(checkingMobileNo)
				{
					System.out.print("Enter the Staff Member Mobile Number:");
					staffMemberMobileNumber = scanner.next();
					if(Validations.checkMobileNumber(staffMemberMobileNumber))
					{
						subwayStaff.setStaffMemberMobileNo(staffMemberMobileNumber);
						checkingMobileNo = false;
						while(checkingSalary)
						{
							System.out.print("Enter the Staff Member Salary:");
							staffMemberSalary = scanner.nextDouble();
							if(Validations.checkSalary(staffMemberSalary))
							{
								subwayStaff.setStaffMemberSalary(staffMemberSalary);
								checkingSalary = false;
								while(checkingDateOfBirth)
								{
									System.out.print("Enter the Date Of Birth[MM/dd/yyyy]:");
									dob = scanner.next();
									if(Validations.checkDate(dob, new Date()))
									{
										try {
											date= simpleDateFormat.parse(dob);
										} catch (ParseException e) {
											System.out.println(e);											
										}
										subwayStaff.setDateOfBirth(date);
										checkingDateOfBirth = false;
										while(checkingDateOfJoining)
										{
											System.out.print("Enter the Date Of Joining[MM/dd/yyyy]:");
											doj = scanner.next();
											if(Validations.checkDate(doj, new Date()))
											{
												try {
													date1= simpleDateFormat.parse(doj);
												} catch (ParseException e) {
													System.out.println(e);
												}
												subwayStaff.setDateOfJoining(date1);
												System.out.println(subwayStaffDAO.addStaffRecord(subwayStaff));
												checkingDateOfJoining = false;
											}
											else
											{
												System.out.print("\n-----------------------------");
												System.out.println("\nInvalid Date Format...");
												System.out.print("-----------------------------\n\n");
											}
										}
									}
									else
									{
										System.out.print("\n-----------------------------");
										System.out.println("\nInvalid Date Format...");
										System.out.print("-----------------------------\n\n");
									}
								}
							}
							else
							{
								System.out.print("\n------------------------------------------------");
								System.out.println("\nSalary Should Be Between 20000 And 80000...");
								System.out.print("-------------------------------------------------\n\n");
							}
						}
					}
					else
					{
						System.out.print("\n-----------------------------");
						System.out.println("\nInvalid Mobile Number...");
						System.out.print("-----------------------------\n\n");
					}
				}
			}
			else
			{
				System.out.print("\n-------------------------------------------");
				System.out.println("\nProvided email address is invalid...");
				System.out.print("--------------------------------------------\n\n");;
			}		
		}
	}

	@Override
	public void modifyStaffRecordForAll()  {
		SubwayStaff subwayStaff1 = new SubwayStaff();
		checkingName = true;
		checkingEmail = true;
		checkingMobileNo = true;
		checkingSalary = true;
		checkingDateOfBirth = true;
		checkingDateOfJoining = true;
		System.out.print("Enter the Staff Member Id:");
		staffMemberId = scanner.nextInt();
		subwayStaff1 = subwayStaffDAO.findStaffRecord(staffMemberId);
		if(subwayStaff1!=null)
		{					
			while(checkingName)
			{
				System.out.print("\nEnter the Staff Member Name:");
				staffMemberName = scanner.next();		
				if(Validations.checkNameLength(staffMemberName))
				{
					if(Validations.checkValidName(staffMemberName))
					{
						subwayStaff1.setStaffMemberName(staffMemberName);
						checkingName = false;
						System.out.print("Enter the Staff Member Address:");
						staffMemberAddress = scanner.next();
						subwayStaff1.setStaffMemberAddress(staffMemberAddress);
						while(checkingEmail)
						{
							System.out.print("Enter the Staff Member Email Id:");
							staffMemberEmailId = scanner.next();
							if(Validations.checkEmail(staffMemberEmailId))
							{
								subwayStaff1.setStaffMemberEmailId(staffMemberEmailId);
								checkingEmail = false;
								while(checkingMobileNo)
								{
									System.out.print("Enter the Staff Member Mobile Number:");
									staffMemberMobileNumber = scanner.next();
									if(Validations.checkMobileNumber(staffMemberMobileNumber))
									{
										subwayStaff1.setStaffMemberMobileNo(staffMemberMobileNumber);
										checkingMobileNo = false;
										while(checkingSalary)
										{
											System.out.print("Enter the Staff Member Salary:");
											staffMemberSalary = scanner.nextDouble();
											if(Validations.checkSalary(staffMemberSalary))
											{
												subwayStaff1.setStaffMemberSalary(staffMemberSalary);
												checkingSalary = false;
												while(checkingDateOfBirth)
												{
													System.out.print("Enter the Date Of Birth[MM/dd/yyyy]:");
													dob = scanner.next();
													if(Validations.checkDate(dob, new Date()))
													{
														try {
															date = simpleDateFormat.parse(dob);
														} catch (ParseException e) {
															System.out.println(e);
														}
														subwayStaff1.setDateOfBirth(date);
														checkingDateOfBirth = false;
														while(checkingDateOfJoining)
														{
															System.out.print("Enter the Date Of Joining[MM/dd/yyyy]:");
															doj = scanner.next();
															if(Validations.checkDate(doj, new Date()))
															{
																try {
																	date1 = simpleDateFormat.parse(doj);
																} catch (ParseException e) {
																	System.out.println(e);
																}
																subwayStaff1.setDateOfJoining(date1);
																System.out.println(subwayStaffDAO.modifyStaffRecordForAll(subwayStaff1));
																checkingDateOfJoining = false;
															}
															else
															{
																System.out.print("\n-----------------------------");
																System.out.println("\nInvalid Date Format...");
																System.out.print("-----------------------------\n\n");
															}
														}
													}
													else
													{
														System.out.print("\n-----------------------------");
														System.out.println("\nInvalid Date Format...");
														System.out.print("-----------------------------\n\n");
													}
												}
											}
											else
											{
												System.out.print("\n-----------------------------------------------");
												System.out.println("\nSalary Should Be Between 20000 And 80000...");
												System.out.print("------------------------------------------------\n\n");
											}
										}
									}
									else
									{
										System.out.print("\n-----------------------------");
										System.out.println("\nInvalid Mobile Number...");
										System.out.print("-----------------------------\n\n");
									}
								}
							}
							else
							{
								System.out.print("\n----------------------------------------");
								System.out.println("\nProvided email address is invalid...");
								System.out.print("-----------------------------------------\n\n");
							}
						}	
					}
					else
					{
						System.out.print("\n-----------------------------");
						System.out.println("\nInvalid Name Format...");
						System.out.print("-----------------------------\n");
					}
				}
				else
				{
					System.out.print("\n-----------------------------------------------");
					System.out.println("\nMember Name length should be Less Then 15...");
					System.out.print("-----------------------------------------------\n");
				}
			}
		}
		else
		{
			System.out.print("\n----------------------------------");
			System.out.println("\nEmployee Record Not Found....");
			System.out.print("----------------------------------\n");
		}	
	}

	@Override
	public void removeStaffRecord() {
		try {
			System.out.print("\nEnter the Staff Member Id:");
			staffMemberId = scanner.nextInt();
			if(Validations.checkId(staffMemberId))
			{
				subwayStaff2 = subwayStaffDAO.findStaffRecord(staffMemberId);
				if(subwayStaff2!=null)
				{
					System.out.println(subwayStaffDAO.removeStaffRecord(staffMemberId));
				}
				else
				{
					System.out.print("\n----------------------------------");
					System.out.println("\nEmployee Record Not Found....");	
					System.out.print("----------------------------------\n");
				}	
			}
		}catch(CheckCustomerIdException e)
		{
			System.out.println(e);
		}
	}

	@Override
	public void findStaffRecord() {
		System.out.print("\nEnter the Staff Member Id:");
		staffMemberId = scanner.nextInt();
		subwayStaff2 = subwayStaffDAO.findStaffRecord(staffMemberId);
		if(subwayStaff2!=null)
		{
			System.out.println("\n*****************************************************");
			System.out.println("     **Employee Information**   ");
			System.out.println("*****************************************************\n");
			System.out.println("Staff Member Id is		:"+subwayStaff2.getStaffMemberId());
			System.out.println("Staff Member Name is		:"+subwayStaff2.getStaffMemberName());
			System.out.println("Staff Member Address is 	:"+subwayStaff2.getStaffMemberAddress());
			System.out.println("Staff Member Email is		:"+subwayStaff2.getStaffMemberEmailId());
			System.out.println("Staff Member Mobile Number is   :"+subwayStaff2.getStaffMemberMobileNo());
			System.out.println("Staff Member Salary is		:"+subwayStaff2.getStaffMemberSalary());	
			System.out.println("Staff Member DOB is		:"+subwayStaff2.getDateOfBirth());
			System.out.println("Staff Member DOJ is		:"+subwayStaff2.getDateOfJoining());	
			System.out.println("\n*****************************************************\n");
		}
		else
		{
			System.out.print("\n----------------------------------");
			System.out.println("\nEmployee Record Not Found....");
			System.out.print("----------------------------------\n");
		}		
	}
	
	@Override
	public void modifyStaffRecordForAddress() {
		System.out.print("Enter the Staff Member Id:");
		staffMemberId = scanner.nextInt();
		subwayStaff1 = subwayStaffDAO.findStaffRecord(staffMemberId);
		if(subwayStaff1!=null)
		{	
			System.out.print("Enter the Staff Member Address:");
			staffMemberAddress = scanner.next();
			subwayStaff1.setStaffMemberAddress(staffMemberAddress);
			System.out.println(subwayStaffDAO.modifyStaffRecordForAddress(subwayStaff1));
		}
		else
		{
			System.out.print("\n----------------------------------");
			System.out.println("\nEmployee Record Not Found....");
			System.out.print("----------------------------------\n");
		}	
	}

	@Override
	public void modifyStaffRecordForEmail() {
		checkingEmail = true;
		System.out.print("Enter the Staff Member Id:");
		staffMemberId = scanner.nextInt();
		subwayStaff1 = subwayStaffDAO.findStaffRecord(staffMemberId);
		if(subwayStaff1!=null)
		{	
			while(checkingEmail)
			{
				System.out.print("Enter the Staff Member Email Id:");
				staffMemberEmailId = scanner.next();
				if(Validations.checkEmail(staffMemberEmailId))
				{
					subwayStaff1.setStaffMemberEmailId(staffMemberEmailId);
					System.out.println(subwayStaffDAO.modifyStaffRecordForEmail(subwayStaff1));
					checkingEmail = false;
				}
				else
				{
					System.out.print("\n----------------------------------------");
					System.out.println("\nProvided email address is invalid...");
					System.out.print("-----------------------------------------\n\n");
				}
			}
		}
		else
		{
			System.out.print("\n----------------------------------");
			System.out.println("\nEmployee Record Not Found....");
			System.out.print("----------------------------------\n");
		}
	}

	@Override
	public void modifyStaffRecordForNumber() {	
		checkingMobileNo = true;
		System.out.print("Enter the Staff Member Id:");
		staffMemberId = scanner.nextInt();
		subwayStaff1 = subwayStaffDAO.findStaffRecord(staffMemberId);
		if(subwayStaff1!=null)
		{	
			while(checkingMobileNo)
			{
				System.out.print("Enter the Staff Member Mobile Number:");
				staffMemberMobileNumber = scanner.next();
				if(Validations.checkMobileNumber(staffMemberMobileNumber))
				{
					subwayStaff1.setStaffMemberMobileNo(staffMemberMobileNumber);
					System.out.println(subwayStaffDAO.modifyStaffRecordForNumber(subwayStaff1));
					checkingMobileNo = false;
				}
				else
				{
					System.out.print("\n-----------------------------");
					System.out.println("\nInvalid Mobile Number...");
					System.out.print("-----------------------------\n\n");
				}
			}
		}
		else
		{
			System.out.print("\n----------------------------------");
			System.out.println("\nEmployee Record Not Found....");
			System.out.print("----------------------------------\n");
		}
	}
}
