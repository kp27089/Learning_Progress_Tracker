package tracker;

import java.util.Map;

//600 for Java, 400 for DSA, 480 for Databases, and 550 for Spring
public class NotifyCommand implements Command {
    int notification = 0;
    static boolean notified = false;

    public void execute() {
        if(notified){
            System.out.println("Total 0 students have been notified.");
        }else {


            int tempNotification = 0;
            for (Map.Entry<String, Student> map : LearningProgressTracker.getStudentsList().entrySet()) {
                if (Integer.valueOf(map.getValue().java) >= 600) {
                    tempNotification++;
                    String fullName = map.getValue().name + " " + map.getValue().lastName;
                    scheme(map.getValue().email, fullName, "Java");
                }
                if (Integer.valueOf(map.getValue().dsa) >= 400) {
                    tempNotification++;
                    String fullName = map.getValue().name + " " + map.getValue().lastName;
                    scheme(map.getValue().email, fullName, "Dsa");
                }
                if (Integer.valueOf(map.getValue().databases) >= 480) {
                    tempNotification++;
                    String fullName = map.getValue().name + " " + map.getValue().lastName;
                    scheme(map.getValue().email, fullName, "Databases");
                }
                if (Integer.valueOf(map.getValue().spring) >= 550) {
                    tempNotification++;
                    String fullName = map.getValue().name + " " + map.getValue().lastName;
                    scheme(map.getValue().email, fullName, "Spring");
                }
                if (tempNotification > 0) {
                    notification++;
                    tempNotification = 0;
                }
            }
            notified = true;
            System.out.println("Total " + notification + " students have been notified.");
        }
    }


    private void scheme(String email, String userName, String course) {
        System.out.println("To: " + email);
        System.out.println("Re: Your Learning Progress");
        System.out.println("Hello, " + userName + "! You have accomplished our " + course + " course!");
    }


}
