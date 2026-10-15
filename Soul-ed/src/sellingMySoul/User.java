package sellingMySoul;
import java.util.Scanner;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//This class is used for input and output to terminal
		//Will include questions (eg. what do you want to do? a)makeSchedule/Course/Assignment b)print___ c)one of the methods etc.
		//Receives only a, b, c, etc. inputs. Otherwise, will tell the user to retry
		Scanner input = new Scanner(System.in);
		System.out.println("Enter \"make schedule\" to begin");
		String in = input.nextLine();
		if (in.toLowerCase().equals("make schedule")) {
			System.out.println("Please enter your name");
			String userName = input.nextLine();
			System.out.println("Please enter your grade (as an integer)");
			int userGrade = input.nextInt();
			System.out.println("Please enter your student ID (as an integer)");
			int userID = input.nextInt();
			
			Schedule schedule = new Schedule(userName, userGrade, userID);
			
			while (!in.toLowerCase().equals("end")) {
				System.out.println("");
				System.out.println("Hello "+ schedule.getStudent() + ", what would you like to do? Please enter the letter of selection or please enter \"end\" now to exit.");
				System.out.println("a) add a course, assignment, or test to your schedule");
				System.out.println("b) modify, add, or remove an element of your schedule, course, assignment, or test");
				System.out.println("c) print schedule");
				System.out.println("d) print assignments in order of priority by due date of one class");
				
				in = input.next();
				
				if (in.toLowerCase().equals("end")) {
					System.out.println("Thank you for selling your soul! Have a good day.");
					break;
				}
				//check
				if (!(in.toLowerCase().equals("a")||in.toLowerCase().equals("b")||in.toLowerCase().equals("c")||in.toLowerCase().equals("d"))) {
					System.out.println("Invalid selection. Please only enter the letter of selection this time. Lets try again.");
					continue;
				}
				
				//adding course, assignment, or test
				if (in.toLowerCase().equals("a")) {
					System.out.println("Would you like to add a  a)course  b)assignment  c)test?");
					in = input.next();
					//check
					if (!(in.toLowerCase().equals("a")||in.toLowerCase().equals("b")||in.toLowerCase().equals("c")||in.toLowerCase().equals("d"))) {
						System.out.println("Invalid selection. Please only enter the letter of selection this time. Lets try again.");
						continue;
					}
					
					//add course
					if (in.toLowerCase().equals("a")) {
						System.out.println("Please enter the name of the course with no spaces");
						String courseName = input.next();
						System.out.println("Please enter the block of the course. If the course has no block, enter \"none\"");
						String courseBlock = input.next();
						System.out.println("Please enter semester of the course. If the course has no semester, enter \"3\"");
						int courseSemester = input.nextInt();
						Course course1 = new Course(courseName, courseBlock, courseSemester);
						if (courseSemester == 1) {
							schedule.addCourseSemOne(course1);
							System.out.println("Course " + courseName + " has been created");
						} else
						if (courseSemester == 2) {
							schedule.addCourseSemTwo(course1);
							System.out.println("Course " + courseName + " has been created");
						} else
						if (courseSemester == 3) {
							schedule.addExtracurricular(course1);
							System.out.println("Course " + courseName + " has been created");
						}else {System.out.println("Sorry. Semester could not be found.");}
						continue;
					}
					
					//add assignment
					if(in.toLowerCase().equals("b")) {
						System.out.println("Please enter the name of the assignment with no spaces (MAKE IT UNIQUE OR ELSE FURTHER MODIFICATIONS WILL NOT WORK!)");
						String assignmentName = input.next();
						System.out.println("Please enter the year the assignment is due");
						int assignmentDueDateYear = input.nextInt();
						System.out.println("Please enter the month the assignment is due as an integer");
						int assignmentDueDateMonth = input.nextInt();
						System.out.println("Please enter the day the assignment is due as an integer");
						int assignmentDueDateDay = input.nextInt();
						System.out.println("Please enter the name of the course the assignment should be added to (according to how it was initially set up)");
						String assignmentCourse = input.next();
						Assignment assignment = new Assignment(assignmentName, assignmentDueDateYear, assignmentDueDateMonth, assignmentDueDateDay);
						schedule.findCourseThroughName(assignmentCourse).addAssignment(assignment);
						System.out.println("Assignment " + assignmentName + " has been added to course " + assignmentCourse + " successfully.");
						continue;
					}
					
					//add test
					if (in.toLowerCase().equals("c")) {
						System.out.println("Please enter the name of the test without spaces");
						String testName = input.next();
						System.out.println("Please enter the year of the test");
						int testYear = input.nextInt();
						System.out.println("Please enter the month of the test as an integer");
						int testMonth = input.nextInt();
						System.out.println("Please enter the day of the test as an integer");
						int testDay = input.nextInt();
						System.out.println("Please enter the difficulty of the test as an integer (equal to the amount of study sessions required to prepare)");
						int testDifficulty = input.nextInt();
						Test test = new Test(testName, testYear, testMonth, testDay, testDifficulty);
						System.out.println("Please enter the name of the course the test should be added to (according to how it was initially set up)");
						String testCourse = input.next();
						schedule.findCourseThroughName(testCourse).addAssignment(test);
						System.out.println("Test " + testName + " has been added to course " + testCourse + " successfully.");
						continue;
					}
					
					
				}
				
				
				//modify, add, or remove an element of your schedule, course, assignment, or test
				if (in.toLowerCase().equals("b")) {
					System.out.println("Would you like to modify an element of your   a)schedule  b)course  c)assignment  d)test");
					in = input.next();
					
					//modify schedule
					if (in.toLowerCase().equals("a")) {
						//change name/grade/stuID
						//remove course
						System.out.println("Would you like to  a)change your name  b)change your grade  c)student ID  d)remove a course?");
						in = input.next();
						if (in.toLowerCase().equals("a")) {
							System.out.println("Please input your updated name");
							String newName = input.next();
							schedule.setStudent(newName);
							continue;
						}
						if (in.toLowerCase().equals("b")) {
							System.out.println("Please input your updated grade");
							int newGrade = input.nextInt();
							schedule.setGrade(newGrade);
							continue;
						}
						if (in.toLowerCase().equals("c")) {
							System.out.println("Please input your updated studentID");
							int newStuID = input.nextInt();
							schedule.setStuID(newStuID);
							continue;
						}
						if (in.toLowerCase().equals("d")) {
							System.out.println("Please input the name of the course you wish to remove");
							String courseName = input.next();
							schedule.removeCourse(courseName);
							continue;
						}
					}
					
					//modify course
					if (in.toLowerCase().equals("b")) {
						//change course name/block
						//complete assignment
						System.out.println("Please enter the name of the course you wish to make modifications to");
						String courseName = input.next();
						Course course = schedule.findCourseThroughName(courseName);
						System.out.println("Would you like to  a)change course name  b)change course block  c)complete an assignment");
						System.out.println("Unfortunately, to change the semester of the course, you will have to remove this course and remake it.");
						in = input.next();
						if (in.toLowerCase().equals("a")) {
							System.out.println("Please enter the new course name");
							String newCourseName = input.next();
							course.setName(newCourseName);
							continue;
						}
						if (in.toLowerCase().equals("b")){
							System.out.println("Please enter the new course block");
							String newCourseBlock = input.next();
							course.setBlock(newCourseBlock);
							continue;
						}
						if (in.toLowerCase().equals("c")) {
							System.out.println("Please enter the name of the assignment you have completed");
							String assignmentDone = input.next();
							course.completeAssignment(course.getAssignmentThroughName(assignmentDone));
							continue;
						}
					}
					
					//modify assignment
					if (in.toLowerCase().equals("c")) {
						//get due date/time until due 
						//change assignment name/due date
						System.out.println("Please enter the name of the course containing the assignment you would like to make modifications to");
						String courseName = input.next();
						Course course = schedule.findCourseThroughName(courseName);
						if (course.equals(null)) {
							System.out.println("Sorry the course could not be found");
						}
						System.out.println("Please enter the name of the assignment you would like to make modifications to");
						String assignmentName = input.next();
						Assignment assignment = course.getAssignmentThroughName(assignmentName);
						if (assignment.equals(null)) {
							System.out.println("Sorry the course could not be found");
						}
						System.out.println("Would you like to  a)get due date  b)get time until it's due  c)change assignment name  d)change assignment due date");
						in = input.next();
						if (in.toLowerCase().equals("a")) {
							System.out.println(assignment.getDueDate());
							continue;
						}
						if (in.toLowerCase().equals("b")) {
							System.out.println("Difference in days: " + assignment.timeUntilDue());
							continue;
						}
						if (in.toLowerCase().equals("c")) {
							System.out.println("Please enter the new name of the assignment");
							String newName = input.next();
							assignment.setAssignmentName(newName);
							continue;
						}
						if (in.toLowerCase().equals("d")) {
							System.out.println("Please enter the new due date's year");
							int newYear = input.nextInt();
							System.out.println("Please enter the new due date's month as an integer");
							int newMonth = input.nextInt();
							System.out.println("Please enter the new due date's day");
							int newDay = input.nextInt();
							assignment.setDueDate(newYear, newMonth, newDay);
							continue;
						}
					}
					
					//modify test
					if (in.toLowerCase().equals("d")) {
						//view difficulty, test date, time until due
						//change difficulty, assignment name, due date
						//study
						//clear test`
						System.out.println("Please enter the name of the course containing the assignment you would like to make modifications to");
						String courseName = input.next();
						Course course = schedule.findCourseThroughName(courseName);
						System.out.println("Please enter the name of the test you would like to make modifications to");
						String testName = input.next();
						Test test = (Test) course.getAssignmentThroughName(testName);
						System.out.println("Would you like to  a)view difficulty  b)view test date  c)view time until test date  d)change difficulty  e)change test name  f)change test date  g)study for test  h)clear test from schedule");
						in = input.next();
						if (in.toLowerCase().equals("a")) {
							System.out.println("Difficulty: " + test.getDifficulty()); 
							continue;
						}
						if (in.toLowerCase().equals("b")) {
							System.out.println("Test date: " + test.getDueDate());
							continue;
						}
						if (in.toLowerCase().equals("c")) {
							System.out.println("Days until test date: " + test.timeUntilDue());
							continue;
						}
						if (in.toLowerCase().equals("d")) {
							System.out.println("Please enter the new difficulty");
							int diff = input.nextInt();
							test.setDifficulty(diff);
							continue;
						}
						if (in.toLowerCase().equals("e")) {
							System.out.println("Please enter the new test name");
							String newName = input.next();
							test.setAssignmentName(newName);
							continue;
						}
						if (in.toLowerCase().equals("f")) {
							System.out.println("Please enter the new test date's year");
							int newYear = input.nextInt();
							System.out.println("Please enter the new test date's month as an integer");
							int newMonth = input.nextInt();
							System.out.println("Please enter the new test date's day");
							int newDay = input.nextInt();
							test.setDueDate(newYear, newMonth, newDay);
							continue;
						}
						if (in.toLowerCase().equals("g")) {
							test.study(course);
							continue;
						}
						if (in.toLowerCase().equals("h")) {
							test.clearTest(course);
							continue;
						}
					}
				}
				
				
				//print schedule
				if (in.toLowerCase().equals("c")) {
					schedule.print();
					continue;
				}
				
				//print assignments in order of priority by due date of one class
				if (in.toLowerCase().equals("d")) {
					System.out.println("Which class would you like to get the assignments of? Please enter the name of the course");
					String sortingCourseName = input.next();
					Course sortingCourse = schedule.findCourseThroughName(sortingCourseName);
					if (sortingCourse.equals(null)) {
						System.out.println("Sorry the course requested could not be found.");
					} else {
						System.out.println(sortingCourse.sort());
					}			
					continue;
				}
			}
		}
		
		//make schedule/course/assignment/test
		//modify an element of schedule/course/assignment/test
		//print schedule
		//get sorted assignments of one course
		//enter end to exit
		
		input.close();		
	}
}
