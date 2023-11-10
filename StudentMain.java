package code;

public class StudentMain {

	String studentID;
	String studentName;
	String studentMajor;

	public StudentMain(String studentID, String studentName, String studentMajor) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.studentMajor = studentMajor;
	}

	public String getName() {
		return studentName;
	}

	public String getId() {
		return studentID;
	}

	public String getMajor() {
		return studentMajor;
	}

	@Override
	public String toString() {
		return "Student ID: " + studentID + " Student Name: " + studentName + " Student Major: " + studentMajor;
	}

}
