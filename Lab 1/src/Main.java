//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Create a new Singer object singer1 using no argument constructor
        Singer singer1 = new Singer();

        //To display the default values of singer1
        System.out.println("Default values of the singer1 object: ");
        singer1.displaySingerInfo();
        System.out.println();

        //To set the values to singer1 using setters
        singer1.setSingerID(0);
        singer1.setSingerName("Peter");
        singer1.setSingerAddress("Markham Road");
        singer1.setSingerDOB("01/01/1990");
        singer1.setAlbumsPublished(1);

        //To display the values of singer1 after updating the values using setters
        System.out.println("Updated values of the singer1 object: ");
        singer1.displaySingerInfo();

        System.out.println("Hello World");
    }
}