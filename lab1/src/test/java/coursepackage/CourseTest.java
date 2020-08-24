package coursepackage;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseTest {
    Course testCourse;
    Instructor testInstructor;
    int courseNo = 111;

    @Before
    public void setUp() throws Exception {
        testInstructor = new Instructor("Wen", "Xie");
        testCourse = new Course(testInstructor, courseNo);
    }

    @Test
    public void getInstructor() {
        assertEquals(testInstructor, testCourse.getInstructor());
    }

    @Test
    public void getCourseNo() {
        assertEquals(courseNo, testCourse.getCourseNo());
    }
}