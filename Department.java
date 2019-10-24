import java.util.*;

public class Department {
  private String name; // the name of school "Dept of Computing and Info Science"
  private String id; // short name for courses "SOFE", "ELEE", "STAT", etc
  ArrayList<Course> courseList; // all courses offered by the department
  ArrayList<Student> registerList; // all students taking courses in the department.

  public Department(String name, String id) {
    // also initialize the arraylists
    this.name = name;//the instance variable "name" was set equal to the parameter 
    this.id = id;//the instance variable "id" was set equal to the parameter
    this.courseList = new ArrayList<Course>();//the instance array variable "courseList" was set to a new array variable
    this.registerList = new ArrayList<Student>();//the instance array variable "registerList" was set to a new array variable
  }
  
  //an accessor method that returns the instance variable "name"
  public String getName() {
    return this.name;
  }
  
  //an accessor method that returns the instance variable "id'
  public String getId() {
    return this.id;
  }
  
  //an update method that adds course
  public void offerCourse(Course course) {
    if(!this.courseList.contains(course)) {
      this.courseList.add(course);
    }
  }
  
  //an update method that prints the course list
  public void printCoursesOffered() {
    for(Course course : this.courseList) {
      System.out.println(course);
    }
  }
  
  //an update method that prints the 
  //information of students registered in department is printed
  public void printStudentsByName() {
    for(Student student : this.registerList) {
      System.out.println(student.toString());
    }
  }

  public String toString() {
    // returns a string representation of department name, number 
    // of courses offered and number of students registered in the
    // department. Use the format:
    // ECSE: 53 courses, 460 students
    return this.id+": "+this.courseList.size()+" courses, "+this.registerList.size()+" students";
  }
  
  //checks if student is in department
  public Boolean isStudentRegistered(Student student) {
    return this.registerList.contains(student);
  }
  
  public ArrayList<Student> studentsRegisteredInCourse(int code) {
    ArrayList<Student> registeredStudents = new ArrayList<Student>();
    for(Course course : this.courseList) {
      if(course.getNumber() == code) {
        for(Student student : course.classList) {
          if(!registeredStudents.contains(student)) {
            registeredStudents.add(student);
          }
        }
      }
    }
    return registeredStudents;
  }
  
  public void printStudentsRegisteredInCourse(int code) {
    ArrayList<Student> registeredStudents = this.studentsRegisteredInCourse(code);
    for(Student student : registeredStudents) {
      System.out.println(student.getId()+" "+student.getName());
    }
  }
  
  public Course largestCourse() {
    Course largestCourse = this.courseList.get(0);
    for(Course course : this.courseList) {
      if(course.classList.size() > largestCourse.classList.size()) {
        largestCourse = course;
      }
    }
    return largestCourse;
  }
  
  public void registerStudent(Student student) {
    if(!this.registerList.contains(student)) {
      this.registerList.add(student);
    }
  }
}
