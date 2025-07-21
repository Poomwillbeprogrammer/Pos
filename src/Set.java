import java.util.Scanner;

public class Set {

    Scanner input = new Scanner(System.in);

    static String[][] person = new String[100][5];
    static int p = 0;

    public void inClude() {
        Add add = new Add();

        System.out.println("Enter the number of people to include:");
        int count = input.nextInt();
        input.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println("Enter details for person " + (p + 1) + ":");
            System.out.print("Name: ");
            person[p][0] = input.nextLine();
            System.out.print("No: ");
            person[p][1] = input.nextLine();

            String[] dateTime = add.showDateTime();
            add.no = person[p][1];
            add.date = dateTime[0];
            add.time = dateTime[1];
            add.id = add.generateID(add.no, add.date.replace(":", ""), add.time.replace(":", ""));

            person[p][2] = add.date;
            person[p][3] = add.time;
            person[p][4] = add.id;
            System.out.println("ID: " + add.id);
            p++;
        }
        System.out.println("Details of included persons:");
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

        for (int i = 0; i < p; i++) {
            if (person[i][1].equals(noToCheck)) {
                found = true;
                for (int j = i + 1; j < p; j++) {
                    if (person[j][1].equals(noToCheck)) {
                        if (person[j][0].equals(person[i][0])) {

                            boolean alreadyAdded = false;
                            for (int k = 0; k < dupCount; k++) {
                                if (namesHasDuplicate[k].equals(person[i][0])) {
                                    alreadyAdded = true;
                                    break;
                                }
                            }
                            if (!alreadyAdded) {
                                namesHasDuplicate[dupCount++] = person[i][0];
                            }
                        } else {

                            boolean alreadyAddedI = false;
                            boolean alreadyAddedJ = false;
                            for (int k = 0; k < doubleCount; k++) {
                                if (namesHasDouble[k].equals(person[i][0])) alreadyAddedI = true;
                                if (namesHasDouble[k].equals(person[j][0])) alreadyAddedJ = true;
                            }
                            if (!alreadyAddedI) namesHasDouble[doubleCount++] = person[i][0];
                            if (!alreadyAddedJ) namesHasDouble[doubleCount++] = person[j][0];
                        }
                    }
                }
            }
        }
        if (!found) {
            System.out.println("No booking found for NO: " + noToCheck);
        } else {
            if (dupCount > 0) {
                System.out.print("Duplicate booking: ");
                for (int i = 0; i < dupCount; i++) {
                    System.out.print(namesHasDuplicate[i]);
                    if (i < dupCount - 1) System.out.print(", ");
                }
                System.out.println();
            }
            if (doubleCount > 0) {
                System.out.print("Double booking: ");
                for (int i = 0; i < doubleCount; i++) {
                    System.out.print(namesHasDouble[i]);
                    if (i < doubleCount - 1) System.out.print(", ");
                }
                System.out.println();
            }
        }
        System.out.println("Any keys to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        Check.checkProcess();
    }
}