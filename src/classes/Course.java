package classes;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Course {

    /**
     * Default constructor
     */
    public Course() {
    	teachers = new ArrayList<>();
    	students = new ArrayList<>();
    }
    
    /**
     * 
     */
    private int id;
    
    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @param id 
     * @return
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private List<Student> students;


    /**
     * 
     */
    private List<Teacher> teachers;

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 
     * @return
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public List<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * @param teachers 
     * @return
     */
    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    /**
     * @param teacher 
     * @return
     */
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    /**
     * @return
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * @param students 
     * @return
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * @param student 
     * @return
     */
    public void addStudent(Student student) {
        students.add(student);
    }

}