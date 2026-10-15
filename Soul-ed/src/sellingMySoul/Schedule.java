package sellingMySoul;
import java.util.*;
public class Schedule {
	
	private String student;
	private int grade;
	private int stuID;
	private ArrayList<Course>[] courseSchedule;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String getStudent() {
		return student;
	}
	
	public void setStudent(String name) {
		student = name;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public void setStuID(int studentID) {
		stuID = studentID;
	}
	
	public Schedule(String nameOfStudent, int gradeOfStudent, int studentID) {
		student = nameOfStudent;
		grade = gradeOfStudent;
		stuID = studentID;
		ArrayList<Course> semOne = new ArrayList<Course>();
		ArrayList<Course> semTwo = new ArrayList<Course>();
		ArrayList<Course> extracurricular = new ArrayList<Course>();
		courseSchedule = new ArrayList[3];		//whats an unchecked conversion
		courseSchedule[0] = semOne;
		courseSchedule[1] = semTwo;
		courseSchedule[2] = extracurricular;
	}
	
	public ArrayList<Course>[] getCourseSchedule(){
		return courseSchedule;
	}
	
	public void print() {
		System.out.println("Name: "+student);
		System.out.println("Grade: "+grade);
		System.out.println("Student ID: "+stuID);
		System.out.println("");
		System.out.println("Semester 1:");
		for(int i=0; i<courseSchedule[0].size(); i++) {
			System.out.println(courseSchedule[0].get(i) + " Number of assignments: " + courseSchedule[0].get(i).getAssignments().size());
		}
		System.out.println("");
		System.out.println("Semester 2:");
		for(int i=0; i<courseSchedule[1].size(); i++) {
			System.out.println(courseSchedule[1].get(i) + " Number of assignments: " + courseSchedule[1].get(i).getAssignments().size());
		}
		System.out.println("");
		System.out.println("Extracurriculars:");
		for(int i=0; i<courseSchedule[2].size(); i++) {
			System.out.println(courseSchedule[2].get(i) + " Number of assignments: " + courseSchedule[2].get(i).getAssignments().size());
		}
		
	}
	
	public ArrayList<Course>[] addCourseSemOne(Course c){
		courseSchedule[0].add(c);
		return courseSchedule;
	}
	
	public ArrayList<Course>[] addCourseSemTwo(Course c){
		courseSchedule[1].add(c);
		return courseSchedule;
	}
	
	public ArrayList<Course>[] addExtracurricular(Course c){
		courseSchedule[2].add(c);
		return courseSchedule;
	}
	
	public ArrayList<Course>[] removeCourse (String courseName){
		for(int i=0; i<courseSchedule.length; i++) {
			for(int j=0; j<courseSchedule[i].size();j++) {
				if (courseSchedule[i].get(j).getName().toLowerCase().equals(courseName.toLowerCase())) {
					courseSchedule[i].remove(j);
				}	
			}
		}
		return courseSchedule;
	}
	
	public Course findCourseThroughName (String courseName) {
		for(int i=0; i<courseSchedule.length; i++) {
			for(int j=0; j<courseSchedule[i].size();j++) {
				if (courseSchedule[i].get(j).getName().toLowerCase().equals(courseName.toLowerCase()))
					return courseSchedule[i].get(j);
			}
		}
		return null;
	}

}
