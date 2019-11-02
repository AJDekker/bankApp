package labs.StudentDatabase;

public class Student {

    //properties
    private static int id = 1000;
    private String name;
    private String SSN;
    private String email;
    private String userId = null;
    public String courses = "";
    private static final int costOfCourse = 800;
    private int balance;


    public static void main(String[] args) {
        Student student1 = new Student("arjan", "332323");
        Student student2 = new Student("arjan", "332323");
        Student student3 = new Student("arjan", "332323");

        student1.enroll("ben");
        student1.enroll("ben3");
        student1.showCourses();
        student1.checkBalance();
        student1.payTuition(300);
        System.out.println(student1.toString());

        // arjan

    }

    //constructor
    Student(String name, String SSN){
        id++;
        this.name = name;
        this.SSN = SSN;
        setAccountId(this.id, this.SSN, this.userId);
        setEmail();
    }

    //generate email ID based on name 
    private void setEmail(){
        email = name.toLowerCase() + "." + id + "@outlook.com";
        System.out.println("Your email: " + email);
    }

    private void setAccountId(int id, String SSN, String userId){
        double random = Math.random() * (9000-1000) + 1000;
        int max = SSN.length();
        int min = max-4;
        SSN = SSN.substring(min,max);
        this.userId = id + random + SSN;
    }

    private void setUserId(){
        int max = 9000;
        int min = 1000;
        int randNumb = (int) (Math.random() * + (max - min));
        randNumb += min;
        System.out.println(randNumb);
        userId = id + "" + randNumb + SSN.substring(5);
        System.out.println(userId);
    }

    public void enroll(String course){
        course = this.courses + "\n" + course;
        balance = balance + costOfCourse;
    }

    public void payTuition(int amount){
        balance = balance-amount;
        System.out.println("Payment " + balance);
    }

    public void checkBalance(){
        System.out.println("balance "+ balance);
    }

    public void showCourses(){
        System.out.println("courses " + courses);
    }

    public String toString(){
        return "[NAME: "+name+"\n]" + "[COURSES " + courses + "]\n";
    }

}



