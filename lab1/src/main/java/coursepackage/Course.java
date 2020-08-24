package coursePackage;

public class Course {
    private Instructor professor;
    private int courseNo;

    public Course(Instructor professor, int courseNo){
        this.professor = professor;
        this.courseNo = courseNo;
    }

    public Instructor getInstructor(){
        return this.professor;
    }
    public int getCourseNo(){
        return this.courseNo;
    }
}
