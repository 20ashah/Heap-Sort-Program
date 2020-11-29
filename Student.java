/*
 This class models a student with a name and grade 
*/
public class Student {

	// instance variables
	private String name;
	private int grade;

	// constructor
	public Student(String n, int g) {
		name = n;
		grade = g;
	}

	// getting student's name
	public String getName() {
		return name;
	}

	// getting student's name
	public int getGrade() {
		return grade;
	}

	// overriding to string method
	public String toString() {
		return name + ": " + grade;
	}

}
