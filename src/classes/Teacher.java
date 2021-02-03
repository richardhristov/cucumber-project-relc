package classes;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Teacher extends Person {

    /**
     * Default constructor
     */
    public Teacher() {
    	courses = new ArrayList<Course>();
    }

    /**
     * 
     */
    private String honoraryPrefix;


    /**
     * 
     */
    private List<Course> courses;

    /**
     * @return
     */
    public String getHonoraryPrefix() {
        return honoraryPrefix;
    }

    /**
     * @param honoraryPrefix 
     * @return
     */
    public void setHonoraryPrefix(String honoraryPrefix) {
        this.honoraryPrefix = honoraryPrefix;
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
    public void addCourse(Course course) {
        courses.add(course);
    }

}