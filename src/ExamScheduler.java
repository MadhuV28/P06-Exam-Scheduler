/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: DraggableObject
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
import java.util.ArrayList;

/**
 * this class has examscheduler and all related methods
 * 
 * @author Madhu Vuyyuru
 * @author Karthik Ashok
 *
 */
public class ExamScheduler {
  /**
   * - returns a valid Schedule for the given set of rooms and courses, or throws an
   * IllegalStateException if no such schedule exists. This method should contain only a call to the
   * helper method, providing an empty starting Schedule.
   * 
   * @param rooms   array of the Room objects available for exams
   * @param courses array of the Course objects which require exam rooms
   * @return findScheduleHelper(s, 0)
   * @throws IllegalStateException with a descriptive message
   */
  public static Schedule findSchedule(Room[] rooms, Course[] courses) throws IllegalStateException {
    try {
      Schedule s = new Schedule(rooms, courses);
      return findScheduleHelper(s, 0);
    } catch (Exception e) {
      throw new IllegalStateException(e.getMessage());
    }
  }

  /**
   * * If the provided index is equal to the number of courses, check to see if the Schedule is
   * complete. If so, return the schedule; otherwise throw an IllegalStateException indicating that
   * this Schedule is invalid. If the provided index corresponds to a course that has already been
   * assigned to a room, recursively assign the courses at the following indexes and return the
   * resulting schedule. If the provided index corresponds to a course that has NOT already been
   * assigned to a room, iteratively try to assign it to each possible valid Room and recursively
   * assign the courses at the following indexes. If this course cannot be assigned to that room,
   * try the next one; return the resulting schedule.
   * 
   * @param schedule
   * @param index
   * @return - If the provided index corresponds to a course that has already been assigned to a
   *         room, recursively assign the courses at the following indexes and return the resulting
   *         schedule. If the provided index corresponds to a course that has NOT already been
   *         assigned to a room, iteratively try to assign it to each possible valid Room and
   *         recursively assign the courses at the following indexes. If this course cannot be
   *         assigned to that room, try the next one; return the resulting schedule.
   * 
   * @throws IllegalStateException with descriptive message indicating that the schedule is invalid
   */
  private static Schedule findScheduleHelper(Schedule schedule, int index)
      throws IllegalStateException {
    if (index == schedule.getNumCourses()) {
      if (!schedule.isComplete()) {
        throw new IllegalArgumentException("This schedule is invalid");
      } else {
        return schedule;
      }
    } else if (schedule.isAssigned(index)) {
      schedule = findScheduleHelper(schedule, index + 1);
      return schedule;
    } else if (!schedule.isAssigned(index)) {
      for (int i = 0; i < schedule.getNumRooms(); i++) {
        try {
          Schedule sched = schedule.assignCourse(index, i);
          return findScheduleHelper(sched, index + 1);
        } catch (IllegalStateException ise) {

        } catch (Exception e) {
          if (i == schedule.getNumRooms() - 1)
            throw new IllegalStateException("this schedule is not valid");
        }
      }
    }
    return schedule;
  }

  /**
   * - returns an ArrayList containing all possible Schedules for the given set of rooms and
   * courses. (If none can be created, this ArrayList is empty.) This method should contain only a
   * call to the helper method, providing an empty starting Schedule.
   * 
   * @param rooms
   * @param courses
   * @return findAllSchedulesHelper(s, 0);
   */
  public static ArrayList<Schedule> findAllSchedule(Room[] rooms, Course[] courses) {
    try {
      Schedule s = new Schedule(rooms, courses);
      return findAllSchedulesHelper(s, 0);
    } catch (Exception e) {
      throw new IllegalStateException(e.getMessage());
    }
  }

  /**
   * - a private, recursive method that assigns all unassigned courses in a Schedule in ALL POSSIBLE
   * ways, beginning from the index provided as an argument: ○If the provided index is equal to the
   * number of courses, check to see if the Schedule is complete. If so, add it to an ArrayList of
   * possible schedules and return the ArrayList. ○If the provided index corresponds to a course
   * that has already been assigned to a room, recursively add all possible valid schedules from the
   * following indexes to an ArrayList of Schedules and return this ArrayList. ○If the provided
   * index corresponds to a course that has NOT already been assigned to a room, iteratively try to
   * assign it to each possible valid Room and recursively add all possible valid schedules from the
   * following indexes to an ArrayList of Schedules and return this ArrayList.
   * 
   * @param scheudle
   * @param index
   * @return array
   */
  private static ArrayList<Schedule> findAllSchedulesHelper(Schedule schedule, int index) {
    // TODO Auto-generated method stub
    ArrayList<Schedule> array = new ArrayList<Schedule>();
    if (index == schedule.getNumCourses()) {
      if (schedule.isComplete()) {
        array.add(schedule);
        return array;
      }
    }
    if (schedule.isAssigned(index)) {
      array = findAllSchedulesHelper(schedule, index + 1);
      return array;
    } else {
      for (int i = 0; i < schedule.getNumRooms(); i++) {
        try {
          Schedule newSchedule = schedule.assignCourse(index, i);
          array.addAll((findAllSchedulesHelper(newSchedule, index + 1)));
        } catch (IllegalStateException e) {

        } catch (IllegalArgumentException e) {

        }
      }
    }
    return array;
  }
}
