package com.vaishali.basic.presentation;
import java.util.Scanner;

public class MainSubwayStaff {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		UserInterfaceImplementation userInterfaceImplementation = new UserInterfaceImplementation();
		Integer option=null;
		Integer choice=null;
		do
		{
			System.out.println("\n***********************************");
			System.out.println("-----Subway Staff Management-----");
			System.out.println("***********************************");
			System.out.println("1. Add Staff Record");
			System.out.println("2. Modify Staff Record");
			System.out.println("3. Remove Staff Record");
			System.out.println("4. Find Staff Record");
			System.out.println("5. Exit");
			System.out.println("*********************************");
			System.out.print("\nEnter Your Option:");
			option = scanner.nextInt();			
			switch(option)
			{
				case 1:
					userInterfaceImplementation.addStaffRecord();
					break;
					
				case 2:
					do
					{
						System.out.println("\n***********************************");
						System.out.println("-----Modification-----");
						System.out.println("***********************************");
						System.out.println("1. Modify For All");
						System.out.println("2. Modify For Address");
						System.out.println("3. Modify For Email Address");
						System.out.println("4. Modify For Mobile Number");
						System.out.println("5. Exit");
						System.out.println("*********************************");
						System.out.print("\nEnter Your choice:");
						choice = scanner.nextInt();
						switch(choice)
						{
							case 1:
								userInterfaceImplementation.modifyStaffRecordForAll();
								break;
								
							case 2:
								userInterfaceImplementation.modifyStaffRecordForAddress();
								break;
								
							case 3:
								userInterfaceImplementation.modifyStaffRecordForEmail();
								break;
								
							case 4:
								userInterfaceImplementation.modifyStaffRecordForNumber();
								break;
								
							case 5:
								System.out.println("\n**User Want Exit**");
								break;
								
							default:
								System.out.println("\n**Invalid Choice**");
								break;							
						}
					}
					while(choice!=5);
					break;
					
				case 3:
					userInterfaceImplementation.removeStaffRecord();
					break;
					
				case 4:
					userInterfaceImplementation.findStaffRecord();
					break;
					
				case 5:
					System.out.println("\n**User Want Exit**");
					System.exit(0);
				default:
					System.out.println("\n**Invalid Choice**");
					break;
			}
		}
		while(option!=5);
		scanner.close();
	}
}
