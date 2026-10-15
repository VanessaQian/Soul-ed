package sellingMySoul;
import java.util.*;
public class Course {
	private String name;
    private String block;
    private int semester;
    private ArrayList<Assignment> assignments;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Course(String n, String b, int s){
        this.name = n;
        this.block = b;
        this.semester = s;
        this.assignments = new ArrayList<Assignment>();
   }
	
	public String getName() {
		return name;
	}

	public String getBlock() {
		return block;
	}
	
	public int getSemester() {
		return semester;
	}
	
	public ArrayList<Assignment> getAssignments(){
		return assignments;
	}
	
	public Assignment addAssignment(Assignment assignment) {
        assignments.add(assignment);
        this.sort();
        return assignment;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBlock(String block) {
		this.block = block;
	}
	
	public void setSemester(int semester) {
		this.semester = semester;
	}

	public Assignment completeAssignment(Assignment assignment) {
        for(int i = 0; i < assignments.size(); i++){
             Assignment secondAssignment = assignments.get(i);
             if(secondAssignment.getID()==assignment.getID()){
                  assignments.remove(i);
             }
        }
        this.sort();
        return assignment;
   }
	
	public Assignment getAssignmentThroughName (String assignmentName) {
		for(int i=0; i<assignments.size(); i++) {
				if (assignments.get(i).getAssignmentName().toLowerCase().equals(assignmentName.toLowerCase()))
					return assignments.get(i);
			
		}
		return null;
	}

	public String toString() {
		return name + " Semester " + semester + " Block " + block;
	}
	
	
    private void merge(int l, int m, int r) {
        ArrayList<Assignment> L = new ArrayList<>();
        ArrayList<Assignment> R = new ArrayList<>();

        for (int i = 0; i < m - l + 1; i++) {
            L.add(assignments.get(l + i));
        }
        for (int i = 0; i < r - m; i++) {
            R.add(assignments.get(m + 1 + i));
        }

        int i = 0, j = 0, k = l;
        while (i < L.size() && j < R.size()) {
            if (L.get(i).timeUntilDue() <= R.get(j).timeUntilDue()) {
                assignments.set(k, L.get(i));
                i++;
            } else {
                assignments.set(k, R.get(j));
                j++;
            }
            k++;
        }

        while (i < L.size()) {
            assignments.set(k, L.get(i));
            i++;
            k++;
        }

        while (j < R.size()) {
            assignments.set(k, R.get(j));
            j++;
            k++;
        }
        
    }

    public ArrayList<Assignment> sort() {
        sort(0, assignments.size() - 1);
        return assignments;
    }

    private void sort(int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(l, m);
            sort(m + 1, r);
            merge(l, m, r);
        }
    }

}
