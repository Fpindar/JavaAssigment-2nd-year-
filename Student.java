import java.util.*;

public class Student {
  private String id; // course id
  private ArrayList<Course> courses; // contains all courses the student is registered in
  private String name; // course name

  public String getName() {
    return this.name;
  }

  public String getId() {
    return this.id;
  }

  // constructor
  public Student(String id, String name) { 
    // initialize name and id. Also initialize the arraylist
    this.id = id;
    this.name = name;
    this.courses = new ArrayList<Course>();
  }
  
  public void registerFor(Course course) {
    if(!this.courses.contains(course)) {
      this.courses.add(course);
      course.addStudent(this);
    }  
  }
  
  public String toString() {
    // return a string representation of a student using the following format:
    // 100234546 John McDonald
    // Registered courses: ELEE 2110, ELEE 2790, SOFE 2710, SOFE 2800, SOFE 2850
    String str = this.id + " " + this.name + "\n";
      if(this.courses.size() > 0) {
        ArrayList<String> courses = new ArrayList<String>();
        str += "Registered courses: ";
        
        for(Course course: this.courses) {
          courses.add(course.getWholeName());
        }
        
        for(int i = 0; i < courses.size(); i++) {
          str += " " + courses.get(i);
          if(i != courses.size() - 1) {
            str += ",";
          }
        }
      }
      
      return str;
  }
  
  public Boolean isRegisteredInCourse(Course course) {
    return course.classList.contains(this);
  }
}
