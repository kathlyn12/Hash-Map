package code;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class StudentHashTable {

	Scanner scan = new Scanner(System.in);
	static HashMap<String, StudentMain> students;

	public StudentHashTable() {
		students = new HashMap<>();
		scan = new Scanner(System.in);
	}

	public void addStudentId() {
		String user;
		do {
			System.out.print("Student ID: ");
			String studentId = scan.nextLine();

			System.out.print("Student Name: ");
			String studentName = scan.nextLine();

			System.out.print("Student Major: ");
			String studentMajor = scan.nextLine();

			StudentMain newStudent = new StudentMain(studentId, studentName, studentMajor);
			students.put(studentId, newStudent);

			System.out.println("---------------------------");
			System.out.println("Student Information added: \n" + studentId + " - " + studentName + ", " + studentMajor);
			System.out.println("--------------------------------------------------");

			System.out.print("\nAdd another student? [Yes/No]: ");
			user = scan.nextLine();
			System.out.println("------------------------------------");
		} while (user.equalsIgnoreCase("Yes"));
	}

	public void searchStudentId() {
		String user;
		do {
			System.out.print("Enter the Student ID: ");
			String searchingKey = scan.nextLine();
			System.out.println("--------------------------------");

			if (students.containsKey(searchingKey)) {
				StudentMain found = students.get(searchingKey);
				System.out.println("Student ID: " + found.getId() + ", " + found.getName() + ", " + found.getMajor());
				System.out.println("-------------------------------------------------------------");
			} else {
				System.out.println("Student Id does not found!");
			}
			System.out.print("\nDo you want to search again? [Yes/No]: ");
			user = scan.nextLine();
			System.out.println("-------------------------------------------");
		} while (user.equalsIgnoreCase("Yes"));
	}

	public void deleteStudentId() {
		String user;
		do {
			System.out.print("Enter the Student ID: ");
			String deletingKey = scan.nextLine();
			System.out.println("--------------------------------");

			if (students.containsKey(deletingKey)) {
				students.remove(deletingKey);
				System.out.println("Student ID: " + deletingKey);
				System.out.println("--------------------------------");
			} else {
				System.out.println("Student Id does not found!");
			}
			System.out.print("\nDo you want to delete again? [Yes/No]: ");
			user = scan.nextLine();
			System.out.println("-------------------------------------------");
		} while (user.equalsIgnoreCase("Yes"));
	}

	public void displayStudentInfo() {
		if (students.isEmpty()) {
			System.out.println("No records found!");
		} else {
			for (Map.Entry<String, StudentMain> entry : students.entrySet()) {
				StudentMain student = entry.getValue();
				System.out.println("Student Id: " + student.getId() + " | Student Name: " + student.getName()
						+ " | Student Major: " + student.getMajor());
				System.out.println(
						"--------------------------------------------------------------------------------------");
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StudentHashTable SHT = new StudentHashTable();

		boolean again;
		try {
			while (again = true) {
				System.out.println("|STUDENT DIRECTORY|");
				System.out.println("[1] - Add Student");
				System.out.println("[2] - Search Student");
				System.out.println("[3] - Delete Student");
				System.out.println("[4] - Display Student");
				System.out.println("[5] - Exit");
				System.out.println("-----------------------");

				System.out.print("Choose a number: ");
				int choose = scan.nextInt();
				System.out.println("-----------------------");

				switch (choose) {
				case 1:
					SHT.addStudentId();
					break;
				case 2:
					SHT.searchStudentId();
					break;
				case 3:
					SHT.deleteStudentId();
					break;
				case 4:
					SHT.displayStudentInfo();
					break;
				case 5:
					System.out.println("Thank you for using Student Directory!");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid. Choose a corresponding number from the directory!");

				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid. Choose a corresponding number from the directory!");
		}
	}

}
