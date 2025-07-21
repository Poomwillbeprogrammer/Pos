import java.util.Scanner;

public class Check {
    public static void checkProcess () {
        char check ;
        Scanner sc = new Scanner(System.in) ;
        System.out.println("what type of process do you want to do? \na for add \nd for delete \ns for show \nc for check \nq for quit");
        check = sc.next().charAt(0) ;
        switch (check) {
            case 'a':
                System.out.println("You have chosen to add a new entry.");
                Set start = new Set();
                start.inClude();
            case 'd':
                System.out.println("You have chosen to delete an entry.");
                Set de = new Set();
                de.delete();
                break;
            case 'c':
                System.out.println("You have chosen to check entries.");
                Set ch= new Set();
                ch.check();
                break;
            case 's':
                System.out.println("You have chosen to show entries.");
                Set set = new Set();
                set.show();
                break;
            case 'q':
                System.out.println("Quitting the program.");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please try again.");
                System.exit(0);
        }
    }
}

