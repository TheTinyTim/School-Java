import java.util.Scanner;

public class UseCourse {
    
    public static void main (String[] args)
    {
        Scanner input = new Scanner (System.in);
    
        System.out.print ("What's the courses department? (ex. ENG) >> ");
        String department = input.next ().toUpperCase ();
    
        System.out.print ("What's the course number? (ex. 101) >> ");
        int courseNum = input.nextInt ();
    
        System.out.print ("How many credit hours does the course have? >> ");
        int creditHours = input.nextInt ();
        
        //Check to see if the department the user entered is any of the courses the require a lab and use the
        //appropriate class
        if ("BIO CHM CIS PHY".contains (department)) {
            LabCourse labCourse = new LabCourse (department, courseNum, creditHours);
            labCourse.display ();
        } else {
            CollegeCourse course = new CollegeCourse (department, courseNum, creditHours);
            course.display ();
        }
    }
    
}
