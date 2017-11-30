public class LabCourse extends CollegeCourse {
    
    private final int ADDITIONAL_FEE = 50;

    public LabCourse (String department, int courseNumber, int credits)
    {
        super (department, courseNumber, credits);
        setFee (ADDITIONAL_FEE);
    }
    
    @Override
    public void display ()
    {
        System.out.printf ("Lab Course: %s-%s\nCredit Hours: %d\nCourse Fee: $%d\n\n",
                getDepartment (), getCourseNumber (), getCredits (), getFee ());
    }

}
