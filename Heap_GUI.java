
/*
 Arjun Shah
 B Block
 3/9/2020
 Program Description:
 This program takes in an array of students with a name and 
 a grade. Using Min and Max Heaps, this program will sort
 the list of students by name and grade using Heap Sort. 
*/

import java.util.ArrayList;
import javax.swing.*;
import BreezySwing.*;

public class Heap_GUI extends GBFrame {

	// GUI components
	private JLabel nameL, gradeL, deleteL;
	private JTextField nameF, deleteF;
	private IntegerField gradeF;
	private JButton add, sortGrade, sortName, delete;

	// list of students and heaps
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private MaxHeap hMax = new MaxHeap();
	private MinHeap hMin = new MinHeap();

	// constructor to add components
	public Heap_GUI() {
		nameL = addLabel("Name", 1, 1, 1, 1);
		nameF = addTextField("", 1, 2, 1, 1);
		gradeL = addLabel("Grade", 2, 1, 1, 1);
		gradeF = addIntegerField(0, 2, 2, 1, 1);
		gradeF.setText("");
		add = addButton("Add Student", 3, 2, 1, 1);
		sortGrade = addButton("Sort by Grade", 4, 1, 1, 1);
		sortName = addButton("Sort by Name", 4, 2, 1, 1);
		deleteF = addTextField("", 6, 2, 1, 1);
		deleteL = addLabel("Deleted Name", 6, 1, 1, 1);
		delete = addButton("Delete Student", 5, 2, 1, 1);
	}

	// performing actions when buttons are clicked
	public void buttonClicked(JButton button) {
		if (button == add) {
			// adds student to list
			studentList.add(new Student(nameF.getText(), gradeF.getNumber()));
			nameF.setText("");
			gradeF.setText("");
		} else if (button == delete) {
			// deletes student from list
			boolean success = Heap.deleteStudent(deleteF.getText(), studentList);
			if (success) { // if student exists
				messageBox(deleteF.getText() + " has been removed.");
			} else { // if student doesn't exist
				messageBox(deleteF.getText() + " is not a student.");
			}

			deleteF.setText("");
		} else {
			hMax = new MaxHeap();
			hMin = new MinHeap();
			ArrayList<Student> sortedList = new ArrayList<Student>();
			// use min or max heap depending on sort
			if (button == sortGrade) {
				sortedList = hMax.heapSort(studentList);
			} else if (button == sortName) {
				sortedList = hMin.heapSort(studentList);
			}
			// output sorted list of students
			String sortedGrade = "";
			for (int i = 0; i < sortedList.size(); i++) {
				sortedGrade += sortedList.get(i) + "\n";
			}
			messageBox(sortedGrade, 300, 300);
		}
	}

	// main method
	public static void main(String[] args) {
		Heap_GUI gui = new Heap_GUI();
		gui.setSize(450, 400);
		gui.setVisible(true);
	}

}
