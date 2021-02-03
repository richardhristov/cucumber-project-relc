package classes;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Student extends Person {

    /**
     * Default constructor
     */
    public Student() {
    	courses = new ArrayList<Course>();
    }

    /**
     * 
     */
    private String facNo;

    /**
     * 
     */
    private List<Course> courses;

    /**
     * @return
     */
    public String getFacNo() {
        return facNo;
    }

    /**
     * @param facNo 
     * @return
     */
    public void setFacNo(String facNo) {
        this.facNo = facNo;
    }

    /**
     * @return
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * @param courses
     * @return
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * @param course 
     * @return
     */
    public void addSubject(Course course) {
        this.courses.add(course);
    }

}