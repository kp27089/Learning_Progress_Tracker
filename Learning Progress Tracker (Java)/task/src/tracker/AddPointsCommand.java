package tracker;

import java.util.Map;
import java.util.Scanner;

public class AddPointsCommand extends LearningProgressTracker implements Command {
    private static final Scanner scanner = new Scanner(System.in);
    String input;
    String[] points;

    public void execute() {
        System.out.println("Enter an id and points or 'back' to return:");
        while (true) {

            points = scanner.nextLine().split(" ");
            if (points[0].equals("back")) {
                break;
            }

            if (points.length <= 4||points.length>5) {
                System.out.println("Incorrect points format.");
                continue;
            } else if (!LearningProgressTracker.getStudentsList().containsKey(points[0])) {
                System.out.println("No student is found for id=" + points[0]);
                continue;
            } else if (points[1].matches("[a-zA-Z]+") || points[2].matches("[a-zA-Z]+") || points[3].matches("[a-zA-Z]+")
                    || points[4].matches("[a-zA-Z]+")) {
                System.out.println("Incorrect points format.");
                continue;
            } else if (Integer.parseInt(points[1]) < 0 || Integer.parseInt(points[2]) < 0 || Integer.parseInt(points[3]) < 0
                    || Integer.parseInt(points[4]) < 0) {
                System.out.println("Incorrect points format.");
                continue;
            }else{
                Map<String,Student> map = LearningProgressTracker.getStudentsList();
                Student tempStud = map.get(points[0]);
                tempStud.setJava(add(tempStud.getJava(),points[1]));
                tempStud.setDsa(add(tempStud.getDsa(),points[2]));
                tempStud.setDatabases(add(tempStud.getDatabases(),points[3]));
                tempStud.setSpring(add(tempStud.getSpring(),points[4]));

                map.replace(points[0],tempStud);
                LearningProgressTracker.setStudentsList(map);
                System.out.println("Points updated.");

            }


        }
    }

    private String add(String one, String two){
        String result = null;
        try{
            result = String.valueOf(Integer.parseInt(one)+Integer.parseInt(two));
        }catch(NumberFormatException ex){
            result = "NaN";
        }

        return result;
    }
}
