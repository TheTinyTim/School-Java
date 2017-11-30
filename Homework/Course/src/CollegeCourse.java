public class CollegeCourse {
    
    private final int PRICE_PER_CREDIT = 120;

    private String department;
    public String getDepartment () { return department; }
    public void setDepartment (String name) { department = name; }
    
    private int courseNumber;
    public int getCourseNumber () { return courseNumber; }
    public void setCourseNumber (int num) { courseNumber = num; }
    
    private int credits;
    public int getCredits () { return credits; }
    public void setCredits (int amount) { credits = amount; }
    
    private int fee;
    public int getFee () { return fee; }
    public void setFee (int additional) { fee = (credits * PRICE_PER_CREDIT) + additional; }
    
    public CollegeCourse (String department, int courseNumber, int credits)
    {
        this.department = department;
        this.courseNumber = courseNumber;
        this.credits = credits;
        setFee (0);
    }
    
    public void display ()
    {
        System.out.printf ("Course: %s-%s\nCredit Hours: %d\nCourse Fee: $%d\n\n",
                department, courseNumber, credits, fee);
    }
    
}
