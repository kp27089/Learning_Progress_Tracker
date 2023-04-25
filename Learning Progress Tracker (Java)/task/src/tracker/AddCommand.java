package tracker;

import java.util.Map;
import java.util.Scanner;

public class AddCommand implements Command {
    String name;
    String lastName;
    String email;
    int counter = 0;
    private static int id = 9999;


    public void execute() {
        System.out.println("Enter student credentials or 'back' to return.");
        Scanner scanner = new Scanner(System.in);
        String input = null;

        do {
            String credential[];


            input = scanner.nextLine();
            if (input.length() <= 0) {
                System.out.println("Incorrect credentials");
                continue;
            }
            credential = input.split(" ");
            if (credential.length >= 3 && credential[0].length() < 2) {
                System.out.println("Incorrect first name.");
            } else if (credential.length >= 3 && credential[1].length() < 2) {
                System.out.println("Incorrect last name.");
            } else {


                if (credential.length == 1) {
                    input = credential[0];
                    if (!input.equals("back")) {
                        System.out.println("Incorrect credentials");
                    }
                } else if (credential.length < 3) {
                    System.out.println("Incorrect credentials");
                } else {
                    if (credential.length > 3) {
                        name = credential[0];
                        email = credential[credential.length - 1];
                        for (int i = 1; i < credential.length - 1; i++) {
                            if (i == 1) {
                                lastName = credential[1] + " ";
                            } else if (i == credential.length - 2) {
                                lastName = lastName + credential[credential.length - 2];
                            } else {
                                lastName = lastName + credential[i] + " ";
                            }
                        }
                    } else {
                        name = credential[0];
                        lastName = credential[1];
                        email = credential[credential.length - 1];
                    }

                    if (name.matches("^[A-Za-z]+(([',.-][A-Za-z ])?[A-Za-z]*)*$")) {
                        if (lastName.matches("^[A-Za-z]+(([' ,-][A-Za-z ])?[A-Za-z]*)*$")) {
                            if (email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z0-9]+$")) {
                                if(isTaken(email,StudentOccurances.EMAIL)){
                                    System.out.println("This email is already taken.");
                                }else{
                                    Student student = new Student(name, lastName, email);
                                    Map<String,Student> map = LearningProgressTracker.getStudentsList();
                                    map.put(String.valueOf(++id),student);
                                      LearningProgressTracker.setStudentsList(map);

                                    counter++;
                                    System.out.println("The student has been added.");
                                }


                            } else {
                                System.out.println("Incorrect email");
                            }
                        } else {

                            System.out.println("Incorrect last name" + lastName + "-");
                        }
                    } else {

                        System.out.println("Incorrect first name" + "  =" + name + "-");
                    }
                }
            }
        } while (!input.equals("back"));
        System.out.println("Total " + counter + " students were added");


    }


    public Boolean isTaken(String chk, StudentOccurances command){


        Boolean result = false;
        for(String key : LearningProgressTracker.getStudentsList().keySet()){
            if(result){
                break;
            }
            switch (command){
                case EMAIL:
                    result = LearningProgressTracker.getStudentsList().get(key).email.equals(chk);
                    break;
                case NAME:
                    result = LearningProgressTracker.getStudentsList().get(key).name.equals(chk);
                    break;
                case LASTNAME:
                    result = LearningProgressTracker.getStudentsList().get(key).lastName.equals(chk);
                    break;
            }

        }

        return result;
    }



}
