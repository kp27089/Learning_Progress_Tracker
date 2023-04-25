package tracker;

import java.util.Map;
import java.util.Scanner;

public class FindCommand implements Command{
    Scanner scanner = new Scanner(System.in);
    String id;

    @Override
    public void execute() {
        System.out.println("Enter an id or 'back' to return:");
        while (true) {

            id = scanner.nextLine();
            if (id.equals("back")) {
                break;
            }
            if(LearningProgressTracker.getStudentsList().containsKey(id)){
                String java = LearningProgressTracker.getStudentsList().get(id).getJava();
                String dsa = LearningProgressTracker.getStudentsList().get(id).getDsa();
                String daatabases = LearningProgressTracker.getStudentsList().get(id).getDatabases();
                String spring = LearningProgressTracker.getStudentsList().get(id).getSpring();

                System.out.println(id+" points: Java="+java+"; DSA="+dsa+"; Databases="+daatabases+"; Spring="+spring);
            }else{
                System.out.println("No student is found for id="+id);
            }


        }
    }
}
