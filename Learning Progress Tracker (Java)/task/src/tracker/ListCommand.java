package tracker;

import java.util.Map;

public class ListCommand implements Command{


    public void execute(){
        if(LearningProgressTracker.getStudentsList().size()==0){
            System.out.println("No students found");
        }else{
            System.out.println("Students");
            for(Map.Entry<String, Student> map : LearningProgressTracker.getStudentsList().entrySet()){
                System.out.println(map.getKey());
            }
        }
    }
}
