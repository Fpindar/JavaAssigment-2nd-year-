import java.util.*;

public class Course {
  private Department dept;
  private String title; // title of the course (e.g. �Intro to programming�);
  private String code; // course code, e.g. SOFE, ELEE, MANE, etc.
  private int number; // course number, e.g. 1200, 2710, 2800, etc.
  ArrayList<Student> classList; // contains all students registered in this course

  public Course(String code, int number, Department dept, String title) {
    // also initialize the classList;
    this.code = code;
    this.number = number;
    this.dept = dept;
    this.title = title;
    this.classList = new ArrayList<Student>();
  }

  public String toString() {
    // return a string representation of the course with the course code,
    // name, and number of people registered in the course in the following
    // format:
    // SOFE 2710 Object Oriented Programming and Design, Enrollment = 260
    return this.code+" "+this.number+" "+this.title+", Enrollment = "+this.classList.size();
  }
  
  // To get the course name 
  public String getDept() {
    return this.dept.getName();
  }
  
  //to get the course code
  public String getCode() {
    return this.code;
  }
  
  public String getWholeName() {
    return this.code + " " + this.number;
  }
  
  //to get course number
  public int getNumber() {
    return this.number;
  }
  
  public void addStudent(Student student) {
    if(!this.classList.contains(student)) {
      this.classList.add(student);
      this.dept.registerStudent(student);
    }
  }
}
