public class Commands {
    private Course[] courseList;
    private Student[] studentList;
    private Teacher[] teacherList;

    public Commands(Course[] courseList, Student[] studentList, Teacher[] teacherList) {
        setCourseList(courseList);
        setStudentList(studentList);
        setTeacherList(teacherList);
    }

    public Course[] getCourseList() {
        return courseList;
    }

    public void setCourseList(Course[] courseList) {
        this.courseList = courseList;
    }

    public Student[] getStudentList() {
        return studentList;
    }

    public void setStudentList(Student[] studentList) {
        this.studentList = studentList;
    }

    public Teacher[] getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(Teacher[] teacherList) {
        this.teacherList = teacherList;
    }

    public void enroll(String studentID, String courseID){ // This command will help enroll the student specified in the corresponding course. While also updating the money_earned of that course based on its price
        int length = getCourseList().length;

    }

    public void assign(String teacherID,String courseID){   //This command will help assign the teacher specified to the corresponding course

    }

    public void ShowCourses(){    //This command will display a list of all courses

    }

    public void LookupCourse(String courseID){ // This command will display the full details of the specified course

    }

    public void ShowStudents(){ //This command will display a list of all students

    }

    public void LookupStudent(String studentID){ //This command will display the full details of the specified student

    }

    public void ShowTeachers(){ //This command will display a list of all teachers

    }

    public void LookupTeacher(String teacherID){ // This command will display the full details of the specified teacher

    }

    public void ShowProfit(){ //This command will calculate (The total money earned from all courses) - (The sum of all the teachers' salaries) and return the result

    }
}
