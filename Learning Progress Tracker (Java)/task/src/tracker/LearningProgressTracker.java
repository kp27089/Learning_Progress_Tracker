package tracker;

import java.util.*;

public class LearningProgressTracker {

    private static Map<String, Command> commands = new HashMap<>();
    private static Map<String, Student> studentsList = new HashMap<>();
    private static int id = 9999;



    static {

        commands.put("exit", new ExitCommand());
        commands.put("add students", new AddCommand());
        commands.put("back", new BackCommand());
        commands.put("list", new ListCommand());
        commands.put("add points", new AddPointsCommand());
        commands.put("find", new FindCommand());
        commands.put("statistics", new StatisticCommand());
        commands.put("notify", new NotifyCommand());

    }


    public static void main(String[] args) {
        System.out.println("Learning Progress Tracker");

        Scanner scanner = new Scanner(System.in);
        while (true) {

            String input = scanner.nextLine();

            if (input.isBlank()) {
                System.out.println("No input");
                continue;
            }

            Command command = commands.get(input);
            if (command == null) {
                System.out.println("Error: unknown command!");
                continue;
            }
            command.execute();



            if (input.equals("exit")) {
                break;
            }

        }


    }


    public static void setStudentsList(Map<String, Student> studentsList) {
        LearningProgressTracker.studentsList = studentsList;
    }

    public static Map<String, Student> getStudentsList() {
        return studentsList;
    }
}


