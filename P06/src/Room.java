/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Room
// Course: CS 300 Spring 2022
//
// Author: Madhu Vuyyuru and Karthik Ashok
// Email: mvuyyuru@wisc.edu and Kashok@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE /Applications/eclipse-workspace/P06/src/Course.javaTHIS SECTION ///////////////////
//
// pair programming was used for this assignment
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// no outside source code was used
//
//
///////////////////////////////////////////////////////////////////////////////


/**
 * this Class has Room and all related data fields,Constructors and Methods
 * 
 * @author Madhu Vuyyuru
 * @author karthik Ashok
 *
 */
public class Room {
  private String location;// - the building and room number, e.g. “Noland 168”
  private int capacity; // - the maximum number of people who can be in the room at a time

  /**
   * - initializes the data fields to the values of the arguments. If the provided integer is
   * negative (<0), throws an IllegalArgumentException with a descriptive error message.
   * 
   * @param location the building and room number
   * @param capacity the maximum number of people who can be in the room at a given time
   * @throws IllegalArgumentException with a descriptive method saying the capacity can not be less
   *                                  than zero if the given capacity is less than zero
   */
  public Room(String location, int capacity) throws IllegalArgumentException {
    if (this.capacity < 0) {
      throw new IllegalArgumentException("the capacity can not be less than zero");
    }
    this.location = location;
    this.capacity = capacity;
  }

  /**
   * - returns the location of this room
   * 
   * @return this.location
   */
  public String getLocation() {
    return this.location;
  }

  /**
   * - returns the capacity of this room
   * 
   * @return this.capacity
   */
  public int getCapacity() {
    return this.capacity;
  }

  /**
   * returns a NEW Room object with the same location as this one, but with a capacity less than
   * this one’s by the argument’s amount. For example, if Room r has a capacity of 10, calling
   * r.reduceCapacity(3) will return a new Room object with the same location as r but a capacity of
   * 7. If the argument is greater than the given Room’s capacity, this method should throw an
   * IllegalArgumentException with a descriptive error message.
   * 
   * @param reduction the amount of reduction in the number of students in a room
   * @return new Room(location, capacity - reduction)
   * @throw IllegalArgumentException with a descriptive message saying the reduction can not be more
   *        than the room capacity if the given reduction of students is more than the capacity
   */
  public Room reduceCapacity(int reduction) throws IllegalArgumentException {
    if (reduction > capacity) {
      throw new IllegalArgumentException("the reduction can not be more than the room capacity");
    }
    return new Room(location, capacity - reduction);

  }
}
