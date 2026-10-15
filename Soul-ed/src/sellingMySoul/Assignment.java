package sellingMySoul;
import java.time.*;
import java.time.temporal.ChronoUnit;
public class Assignment {

	private String assignmentName;
	private LocalDate dueDate; 
	private int ID; //randomly generated
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public Assignment(String assignment, int year, int month, int dayOfMonth) {
		assignmentName = assignment;
		dueDate = LocalDate.of(year, month, dayOfMonth);
		ID = (int)(Math.random()*100000000);
	}
	
	public String getAssignmentName() {
		return assignmentName;
	}
	
	public LocalDate getDueDate() {
		return dueDate;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}
	
	public void setDueDate(int year, int month, int dayOfMonth) {
		dueDate = LocalDate.of(year, month, dayOfMonth);
	}
	
	public String toString() {
		return assignmentName + " Due " + dueDate;
	}
	
	public long timeUntilDue() {
	    long diff = ChronoUnit.DAYS.between(LocalDate.now(), dueDate);
	    return diff;
	}
	
}

