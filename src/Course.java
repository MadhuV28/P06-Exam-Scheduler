/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Course
// Course: CS 300 Spring 2022
//
// Author: Madhu Vuyyuru and Karthik Ashok
// Email: mvuyyuru@wisc.edu and kAshok@wisc.edu
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
/**
 * This class has Course and All related data fields,methods and Constructors
 * 
 * @author Madhu Vuyyuru
 * @author Karthik Ashok
 *
 */
public class Course {
  private String name;// - the name of the course, e.g. “CS300”
  private int numStudents;// - the number of students enrolled in the course, e.g. 250

  /**
   * initializes the data fields to the values of the arguments. If the provided integer is negative
   * (<0), throws an IllegalArgumentException with a descriptive error message.
   * 
   * @param name
   * @param numStudents the number of students in the course
   * @throw IllegalArgumentException with a descriptive messsage saying the number of students can
   *        not be less than zero if the number of students given is less than zero
   */
  public Course(String name, int numStudents) throws IllegalArgumentException {
    if (numStudents < 0) {
      throw new IllegalArgumentException("the number of students can not be less than zero");
    }
    this.name = name;
    this.numStudents = numStudents;
  }

  /**
   * - returns the name of this course
   * 
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * returns the number of students enrolled in this course
   * 
   * @return this.numStudents
   */
  public int getNumStudents() {
    return numStudents;
  }
}

