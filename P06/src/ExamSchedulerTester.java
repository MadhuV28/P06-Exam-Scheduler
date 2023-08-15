/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ExamSchedulerTester
// Course: CS 300 Spring 2022
//
// Author: Karthik Ashok and Madhu Vuyyuru
// Email: kashok@wisc.edu and mvuyyuru@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Madhu Vuyyuru
// Partner Email: mvuyyuru@wisc.edu
// Partner Lecturer's Name: Hobbes Legault
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// no outside source code was used
//
//
///////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;

/**
 * This class has ExamScheduler and All related data fields, methods and constructors
 * 
 * @author Karthik Ashok
 * @author Madhu Vuyyuru
 *
 */
public class ExamSchedulerTester {
  /**
   * this main method runs all tests
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(runAllTests());

  }

  /**
   * this tester method tests to see if the Course Class runs correctly
   * 
   * @return true if all test scenarios work correctly and false if even one tester is incorrect
   */

  public static boolean testCourse() {
    // tests that a course can be created
    Course testCourse = new Course("TestCourse", 123);

    // tests the getName method works
    if (testCourse.getName() != "TestCourse") {
      return false;
    }
    // tests that getNumStudents method works
    if (testCourse.getNumStudents() != 123) {
      return false;
    }

    // tests that the correct error is thrown when incorrect inputs are put in
    try {
      Course testCourse1 = new Course("TestCourse", -123);
      return false;
    } catch (IllegalArgumentException iae) {
      System.out.println(iae.getMessage());
    } catch (Exception e) {
      System.out.println("Unexpected exception was caught!");
    }
    return true;
  }

  /**
   * this tester method tests to see if the Room class runs correctly
   * 
   * @return true if all test scenarios work correctly and false if even one tester is incorrect
   */

  public static boolean testRoom() {
    // tests that a room can be created
    Room testRoom = new Room("TestRoom", 123);

    // tests that getLocation method has correct functionality
    if (testRoom.getLocation() != "TestRoom") {
      return false;
    }
    // tests that getCapacity method has correct functionality
    if (testRoom.getCapacity() != 123) {
      return false;
    }

    // tests that the correct error is thrown when incorrect inputs are put in
    try {
      Room testRoom1 = new Room("TestRoom", -123);
      return false;
    } catch (IllegalArgumentException iae) {
      System.out.println(iae.getMessage());
    } catch (Exception e) {
      System.out.println("Unexpected exception was caught!");
    }

    // tests that reduceCapcity method has correct functionality with valid inputs
    if (testRoom.reduceCapacity(3).getCapacity() != 120) {
      return false;
    }

    // tests that reduceCapcity throws correct exception with invalid input
    try {
      testRoom.reduceCapacity(124);
      return false;
    } catch (IllegalArgumentException iae) {
      System.out.println(iae.getMessage());
    } catch (Exception e) {
      System.out.println("Unexpected exception was caught!");
    }
    return true;
  }

  /**
   * this tester method tests to see if the accessors in Schedule runs correctly
   * 
   * @return true if all test scenarios work correctly and false if even one tester is incorrect
   */

  public static boolean testScheduleAccessors() {
    Room[] rooms = new Room[] {new Room("TestRoom", 123), new Room("TestRoom1", 123),
        new Room("TestRoom2", 123), new Room("TestRoom3", 123), new Room("TestRoom4", 123)};
    Course[] courses = new Course[] {new Course("TestCourse", 123), new Course("TestCourse1", 123),
        new Course("TestCourse2", 123)};
    Schedule testSchedule = new Schedule(rooms, courses);

    if (testSchedule.getNumRooms() != 5) {
      return false;
    }
    if (testSchedule.getNumCourses() != 3) {
      return false;
    }
    testSchedule = testSchedule.assignCourse(0, 0);
    testSchedule = testSchedule.assignCourse(1, 1);
    testSchedule = testSchedule.assignCourse(2, 2);


    if (testSchedule.getRoom(1).getLocation() != rooms[1].getLocation()) {
      return false;
    }

    // test getRoom with invalid inputs
    try {
      testSchedule.getRoom(7).getLocation();
    } catch (IndexOutOfBoundsException ioobe) {
      System.out.println(ioobe.getMessage());
    } catch (Exception e) {
      System.out.println("Unexpected exception was caught!");
    }


    if (testSchedule.getCourse(1) != courses[1]) {
      return false;
    }

    // test getCourse wit invalid inputs
    try {
      testSchedule.getCourse(7);
    } catch (IndexOutOfBoundsException ioobe) {
      System.out.println(ioobe.getMessage());
    } catch (Exception e) {
      System.out.println("Unexpected exception was caught!");
    }


    if (testSchedule.isAssigned(1) != true) {
      return false;
    }



    if (!testSchedule.getAssignment(1).getLocation().equals(rooms[1].getLocation())) {
      return false;
    }

    // test getAssignment with invalid inputs
    Room[] rooms1 = new Room[] {new Room("TestRoom", 123), new Room("TestRoom1", 123),
        new Room("TestRoom2", 123), new Room("TestRoom3", 123), new Room("TestRoom4", 123)};
    Course[] courses1 = new Course[] {new Course("TestCourse", 123), new Course("TestCourse1", 123),
        new Course("TestCourse2", 123)};
    Schedule testSchedule1 = new Schedule(rooms1, courses1);
    try {
      testSchedule1.getAssignment(2);
      return false;
    } catch (IllegalArgumentException iae) {
      System.out.println("The course has not been assigned a room");
    } catch (Exception e) {
      System.out.println("Unexpected exception was caught!");
    }

    try {
      testSchedule1.getAssignment(5);
      return false;
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      System.out.println("Unexpected exception was caught!");
    }



    if (testSchedule.isComplete() != true) {
      return false;
    }
    if (!testSchedule.toString()
        .equals("{TestCourse: TestRoom, TestCourse1: TestRoom1, TestCourse2: TestRoom2}")) {
      return false;
    }

    return true;
  }

  /**
   * this tester method tests to see if the Assign Course runs correctly
   * 
   * @return true if all test scenarios work correctly and false if even one tester is incorrect
   */

  public static boolean testAssignCourse() {
    Room[] rooms = new Room[] {new Room("TestRoom", 123), new Room("TestRoom1", 123),
        new Room("TestRoom2", 123), new Room("TestRoom3", 123), new Room("TestRoom4", 123)};
    Course[] courses = new Course[] {new Course("TestCourse", 123), new Course("TestCourse1", 123),
        new Course("TestCourse2", 123)};
    Schedule testSchedule = new Schedule(rooms, courses);

    // tests for correct functionality of assignCourse()
    testSchedule = testSchedule.assignCourse(1, 1);
    if (testSchedule.isAssigned(1) != true) {
      return false;
    }

    // tests for invalid roomIndex given an invalid course index and the correct exception is thrown
    try {
      testSchedule.assignCourse(7, 1);
      return false;
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      System.out.println("Unexpected exception was caught!");
    }

    // tests for invalid roomIndex given an invalid room index and the correct exception is thrown
    try {
      testSchedule.assignCourse(1, 7);
      return false;
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      System.out.println("Unexpected exception was caught!");
    }

    // tests for if the given course has already been assigned a room or if the room does not have
    // sufficient capacity and the correct exception is thrown
    try {
      testSchedule.assignCourse(1, 1);
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      System.out.println("Unexpected exception was caught!");
    }

    return true;
  }

  /**
   * this tester method tests to see if the FindALlSchedules runs correctly
   * 
   * @return true if all test scenarios work correctly and false if even one tester is incorrect
   */

  public static boolean testFindAllSchedules() {
    Room[] rooms =
        new Room[] {new Room("Room1", 100), new Room("Room2", 150), new Room("Room3", 75)};
    Course[] courses =
        new Course[] {new Course("CS200", 50), new Course("CS300", 110), new Course("CS400", 75)};
    // testing for a valid schedule that should produce correct results
    ArrayList<Schedule> testList = ExamScheduler.findAllSchedule(rooms, courses);
    for (int i = 0; i < testList.size(); i++) {
      if (i == 0
          && !testList.get(i).toString().equals("{CS200: Room1, CS300: Room2, CS400: Room3}, ")) {
        return false;
      } else if (i == 0
          && !testList.get(i).toString().equals("{CS200: Room3, CS300: Room2, CS400: Room1}, ")) {
        return false;
      }
    }
    // testing for a schedule that should produce nothing
    Room[] rooms1 =
        new Room[] {new Room("Room1", 100), new Room("Room2", 150), new Room("Room3", 75)};
    Course[] courses1 =
        new Course[] {new Course("CS200", 200), new Course("CS300", 300), new Course("CS400", 400)};
    ArrayList<Schedule> testList1 = ExamScheduler.findAllSchedule(rooms1, courses1);
    if (testList1.size() != 0) {
      return false;
    }
    return true;
  }


  /**
   * this tester method tests to see if the FindSchedules runs correctly
   * 
   * @return true if all test scenarios work correctly and false if even one tester is incorrect
   */
  public static boolean testFindSchedules() {
    Room[] rooms =
        new Room[] {new Room("Room1", 100), new Room("Room2", 150), new Room("Room3", 75)};
    Course[] courses =
        new Course[] {new Course("CS200", 50), new Course("CS300", 110), new Course("CS400", 75)};

    if (!ExamScheduler.findSchedule(rooms, courses).toString()
        .equals("{CS200: Room1, CS300: Room2, CS400: Room3}")) {

      return false;
    }

    try {
      Room[] rooms1 =
          new Room[] {new Room("Room1", 0), new Room("Room2", 150), new Room("Room3", 75)};
      Course[] courses1 =
          new Course[] {new Course("CS200", 50), new Course("CS300", 110), new Course("CS400", 75)};
      ExamScheduler.findSchedule(rooms1, courses1).toString();
      return false;
    } catch (IllegalStateException e) {
      System.out.println(e.getMessage());
    }
    return true;
  }

  /**
   * this tester method tests to see if the all the test methods runs correctly
   * 
   * @return true if all test scenarios work correctly and false if even one tester is incorrect
   */
  public static boolean runAllTests() {
    if (testCourse() && testRoom() && testScheduleAccessors() && testAssignCourse()) {
      return true;
    }
    return false;
  }
}
