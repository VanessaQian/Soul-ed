package sellingMySoul;

public class Test extends Assignment {
	
	private int difficulty;
	public Test(String assignment, int year, int month, int dayOfMonth, int difficulty) {
		super(assignment, year, month, dayOfMonth);
		this.difficulty = difficulty;
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//uses an int difficulty instance variable to determine how many study sessions are needed
	public int getDifficulty() {
		return difficulty;
	}
	
	public void setDifficulty(int newDiff) {
		difficulty = newDiff;
	}
	
	public void study(Course assignmentsCourse) {
		difficulty--;
		if (difficulty==0) {
			System.out.println("Test studying has been completed.");
			assignmentsCourse.completeAssignment(this);
		}
	}
	
	public void clearTest(Course assignmentsCourse) {
		assignmentsCourse.completeAssignment(this);
	}

}
