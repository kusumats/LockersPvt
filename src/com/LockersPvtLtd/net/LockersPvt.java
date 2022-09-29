package com.LockersPvtLtd.net;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LockersPvt {

	public static void main(String[] args) throws IOException {

		System.out.println("Welcome to LockersPvtLtd");
		System.out.println("Developer : Kusuma");
		Scanner input = new Scanner(System.in);
		menuOptions(input);
	}

	private static void menuOptions(Scanner input) throws IOException {
		int choice = -1;
		do {
			System.out.println("1.Show Files");
			System.out.println("2.Show File Options Menu ");
			System.out.println("3.Quit");
			System.out.println("Enter your choince :");
			Scanner input1 = new Scanner(System.in);
			choice = input1.nextInt();
			switch (choice) {
			case 1:
				File file = new File("D:/java");
				File[] contents = file.listFiles();
				Arrays.sort(contents);
				System.out.println("List of Files in directory");
				for(File content : contents){
					if(content.isFile()){
						System.out.println(content.getName());
					}
				}
				
				break;
			case 2:
				fileOptions();
				break;
			case 3:
				System.out.println("exit...");
				System.exit(0);
				break;
			}
		} while (choice != 0);

	}

	private static void fileOptions() throws IOException {
		System.out.println("Please select the following file options");
		System.out.println("1.Insert");
		System.out.println("2.Delete");
		System.out.println("3.Search");
		System.out.println("4.Navigate to main menu");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		switch (option) {
		case 1:
			File dir = new File("D:/java");
			System.out.println("Enter file name");
			Scanner inputCase2 = new Scanner(System.in);
			String fileName = inputCase2.nextLine();
			File actualFile = new File(dir, fileName);
			boolean created = actualFile.createNewFile();
			System.out.println("created successfully");
			fileOptions();
			break;
		case 2:
			File dir1 = new File("D:/java");
			System.out.println("Enter file name");
			Scanner inputCase3 = new Scanner(System.in);
			String deleteFile = inputCase3.nextLine();
			File file = new File(dir1, deleteFile);
			if (file.exists()) {
				file.delete();
				System.out.println("File deleted successfully");
			} else {
				System.out.println("File not found in that path");
			}
			fileOptions();
			break;
		case 3:
			File direcotry = new File("D:/java");
			boolean flag = false;
			System.out.println("Enter filename to be searched");
			Scanner searchFile = new Scanner(System.in);
			String enteredFileName = searchFile.nextLine();
			String[] search = direcotry.list();
			if (search == null) {
				System.out.println("Empty directory");
			} else {
				for (int i = 0; i < search.length; i++) {
					String filename = search[i];
					if (filename.equals(enteredFileName)) {
						flag = true;
						System.out.println("Filename found :" + filename);
					}
				}
				if (!flag) {
					System.out.println("Filename not found ");
				}
			}
			fileOptions();
			break;
		case 4:
			Scanner input = new Scanner(System.in);
			menuOptions(input);
			break;
		}
	}
}
