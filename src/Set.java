import java.util.Arrays;

public class List {
    Add arr[] ;
    int count ;
    public List() {
        
    }

    public void show() {
        System.out.println("Showing all included persons:");
        for (int i = 0; i < p; i++) {
            System.out.println("Person " + (i + 1) + ": " +
                    person[i][0] + ", " + person[i][1] + ", " +
                    person[i][2] + ", " + person[i][3] + ", " + person[i][4]);
        }
        System.out.println("Any keys to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        Check.checkProcess();
    }

    public void delete() {
        System.out.println("Enter the ID of the person to delete:");
        String idToDelete = input.nextLine();
        boolean found = false;
        for (int i = 0; i < p; i++) {
            if (person[i][4].equals(idToDelete)) {
                found = true;
                System.out.println("Deleting person: " + person[i][0] + ", " + person[i][1]);

                for (int j = i; j < p - 1; j++) {
                    person[j] = person[j + 1];
                }
                p--;
                break;
            }
        }
        System.out.println("Any keys to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        Check.checkProcess();
    }

    public void check() {
        System.out.println("Enter the NO you want to check:");
        String noToCheck = input.nextLine();
        boolean found = false;
        String[] namesHasDuplicate = new String[p];
        String[] namesHasDouble = new String[p];
        int dupCount = 0;
        int doubleCount = 0;

