/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Schedule
// Course: CS 300 Spring 2022
//
// Author: Madhu Vuyyuru and Karthik Ashok
// Email: mvuyyuru@wisc.edu and Kashok@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// pair programming was used for this assignment
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// no outside source code was used
//
//
///////////////////////////////////////////////////////////////////////////////
import java.util.Arrays;

/**
 * this class has Schedule and all related data fields,constructors and methods
 * 
 * @author Madhu Vuyyuru
 * @author Karthik Ashok
 *
 */
public class Schedule {
  private Room[] rooms;// an array of the Room objects available for exams
  private Course[] courses; // - an array of the Course objects which require exam rooms
  private int[] assignments;// - an array where the integer at index N is the index of the room that
                            // course[N] has been assigned to

  /**
   * initializes the rooms and courses arrays to the provided values, and creates an assignments
   * array of the correct length where all values are -1, indicating that the corresponding course
   * has not yet been assigned a room.
   * 
   * @param rooms   array of the Room objects available for exams
   * @param courses array of the Course objects which require exam rooms
   */
  public Schedule(Room[] rooms, Course[] courses) {
    this.rooms = rooms;
    this.courses = courses;
    this.assignments = new int[courses.length];
    for (int i = 0; i < assignments.length; i++) {
      assignments[i] = -1;
    }
  }

  /**
   * a private constructor! Initializes the rooms and courses arrays to the provided values and
   * assignments to the provided assignments array. May assume the assignments array is the correct
   * length (equal to the length of the courses array).
   * 
   * @param rooms       array of the Room objects available for exams
   * @param courses     array of the Course objects which require exam rooms
   * @param assignments array where the integer at index N is the index of the room that course[N]
   *                    has been assigned to
   */
  private Schedule(Room[] rooms, Course[] courses, int[] assignments) {
    this.rooms = rooms;
    this.courses = courses;
    this.assignments = assignments;
  }

  /**
   * - returns the number of rooms available in this schedule
   * 
   * @return room.length
   */
  public int getNumRooms() {
    return rooms.length;
  }

  /**
   * - returns the Room object at the given index in the rooms array; throws an
   * IndexOutOfBoundsException with a descriptive error message if the given index is invalid
   * 
   * @param index
   * @return rooms[index]
   * @throws IndexOutOfBoundsException with a descriptive error message if the given index is
   *                                   invalid
   */
  public Room getRoom(int index) throws IndexOutOfBoundsException {
    try {
      return rooms[index];
    } catch (IndexOutOfBoundsException e) {
      throw new IndexOutOfBoundsException("The index is invalid");
    }
  }

  /**
   * - returns the number of courses in this schedule
   * 
   * @return courses.length
   */
  public int getNumCourses() {
    return courses.length;
  }

  /**
   * - returns the Course object at the given index in the courses array; throws an
   * IndexOutOfBoundsException with a descriptive error message if the given index is invalid
   * 
   * @param index
   * @return courses[index]
   * @throws IndexOutOfBoundsException with a descriptive error message saying The index is invalid
   *                                   if the given index is invalid
   */
  public Course getCourse(int index) throws IndexOutOfBoundsException {
    try {
      return courses[index];
    } catch (IndexOutOfBoundsException e) {
      throw new IndexOutOfBoundsException("The index is invalid");
    }
  }

  /**
   * - returns true if and only if the course at the given index has been assigned a room; false
   * otherwise
   * 
   * @param index
   * @return true if and only if course at the given index has been assigned a room and false
   *         otherwise
   */
  public boolean isAssigned(int index) {
    if (assignments[index] != -1) {
      return true;
    }
    return false;
  }

  /**
   * returns the Room object assigned to the course at the given index; throws an
   * IllegalArgumentException if the course has not been assigned a room, or an
   * IndexOutOfBoundsException with a descriptive error message if the given course index is invalid
   * 
   * @return rooms[assignments[index]]
   * @throws IllegalArgumentException  with a descriptive message saying The course has not been
   *                                   assigned a room if course has not been assigned a room
   * @throws indexOutOfBoundsException with a descriptive error message saying The index is invalid
   *                                   if the given index is invalid
   */
  public Room getAssignment(int index) throws IllegalArgumentException, IndexOutOfBoundsException {

    try {
      if (assignments[index] == -1) {
        throw new IllegalArgumentException("The course has not been assigned a room");
      }
      return rooms[assignments[index]];
    } catch (IndexOutOfBoundsException e) {
      throw new IndexOutOfBoundsException("The index is invalid");
    }
  }

  /**
   * returns true if and only if all courses have been assigned to rooms; false otherwise
   * 
   * @return true if and only if all courses have been assigned to rooms, false otherwise
   */
  public boolean isComplete() {
    for (int i = 0; i < assignments.length; i++) {
      if (assignments[i] == -1) {
        return false;
      }
    }
    return true;
  }

  /**
   * returns a NEW Schedule object with the course at the first argument index assigned to the room
   * at the second argument index; throws an IndexOutOfBoundsException with a descriptive error
   * message if the given course or room index is invalid, or an IllegalArgumentException with a
   * descriptive error message if the given course has already been assigned a room, or if the room
   * does not have sufficient capacity.
   * 
   * @param courseIndex
   * @param roomIndex
   * @return new Schedule(rooms,courses,assignments)
   * @throws IllegalArgumentException      with a descriptive error message if the given course or
   *                                       room index is invalid
   * @throws IndexOutOfBoundsExceptionwith a descriptive error message if the given course has
   *                                       already been assigned a room, or if the room does not
   *                                       have sufficient capacity.
   */
  public Schedule assignCourse(int courseIndex, int roomIndex)
      throws IllegalArgumentException, IndexOutOfBoundsException {
    try {
      int[] x = Arrays.copyOf(assignments, getNumCourses());
      Room[] rooms1 = Arrays.copyOf(rooms, getNumRooms());
      rooms1[roomIndex] =
          getRoom(roomIndex).reduceCapacity(getCourse(courseIndex).getNumStudents());
      x[courseIndex] = roomIndex;
      return new Schedule(rooms1, courses, x);
    } catch (IndexOutOfBoundsException e) {
      throw new IndexOutOfBoundsException("The course or room index is invlaid");
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("The course has not yet been assigned yet to a room");
    }
  }

  @Override
  /**
   * create a String representation, formatted as follows: {CS300: AG 125, CS200: HUM 3650, CS400:
   * Unassigned} where the courses were named ["CS300", "CS200", "CS400"], and the rooms had
   * locations ["SCI 180", "HUM 3650", "AG 125"]. Note that CS400 has not yet been assigned a room,
   * so the corresponding assignments array contains the values [2, 1, -1] at this time.
   */
  public String toString() {
    String output = "{";
    for (int i = 0; i < courses.length; i++) {
      String location = "";
      if (assignments[i] == -1) {
        location = "Unassigned";
      } else {
        location = rooms[assignments[i]].getLocation();
      }
      output += courses[i].getName() + ": " + location + ", ";
    }
    output = output.substring(0, output.length() - 2);
    output = output.trim() + "}";
    return output;
  }
}
